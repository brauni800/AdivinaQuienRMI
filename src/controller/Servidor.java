package controller;

@SuppressWarnings("serial")
public class Servidor extends java.rmi.server.UnicastRemoteObject implements interfaz.InterfazServidor {

	java.util.ArrayList<String> usuariosRegistrados;

	public Servidor() throws java.rmi.RemoteException {
		super();
		usuariosRegistrados = new java.util.ArrayList<String>();
	}

	@Override
	public String registrar(String login) throws java.rmi.RemoteException {
		String respuesta;
		if (usuariosRegistrados.contains(login)) {
			respuesta = "usuarioDuplicado";
		} else {
			usuariosRegistrados.add(login);
			respuesta = "usuarioAnadido";
			System.out.println("Usuario " + login + " registrado.");
		}
		return respuesta;
	}

	@Override
	public void difundirMensaje(String mensaje) throws java.rmi.RemoteException {
		for (int i = 0; i < usuariosRegistrados.size(); i++) {
			mostrarMensaje(usuariosRegistrados.get(i), mensaje);
		}
	}

	@Override
	public boolean desconectar(String login) throws java.rmi.RemoteException {
		boolean desconectado = false;
		// Quitamos al usuario del mapa de usuarios registrados
		desconectado = usuariosRegistrados.remove(login);
		if (desconectado) {
			System.out.println("Usuario " + login + " desconectado");
		}
		return desconectado;
	}

	public void mostrarMensaje(String nombreObjetoRemoto, String mensaje) {
		try {
			java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry();
			System.out.print("Buscando el objeto remoto de " + nombreObjetoRemoto + "...");
			interfaz.InterfazCliente instancia_local = (interfaz.InterfazCliente) registry.lookup(nombreObjetoRemoto);
			System.out.println(" Objeto remoto encontrado");

			// Envia el mensaje al usuario
			instancia_local.mostrarMensaje(mensaje);
			System.out.println("Mensaje enviado");
		} catch (java.rmi.RemoteException ex) {
			java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (java.rmi.NotBoundException ex) {
			java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	public void inicializarObjetoRemoto() {
		try {
			System.setProperty("java.rmi.server.hostname","192.168.1.2");
			java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry();
			String nombre_objeto_remoto = "servidor";
			registry.rebind(nombre_objeto_remoto, (interfaz.InterfazServidor) this);
			System.out.println("Servidor...");
		} catch (java.rmi.RemoteException ex) {
			System.out.println("fallo el servidor");
			java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}
}
