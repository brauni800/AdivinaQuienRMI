package controller;

@SuppressWarnings("serial")
public class ControladorCliente extends java.rmi.server.UnicastRemoteObject implements interfaz.InterfazCliente {

	private view.VentanaCliente ventanaCliente;
	private interfaz.InterfazServidor instancia_local;
	private String login;

	public ControladorCliente(ControladorRegistrar controladorRegistrar) throws java.rmi.RemoteException {
		this.ventanaCliente = new view.VentanaCliente();
		this.ventanaCliente.setPanel(new view.PanelJanKenPo());
		this.instancia_local = controladorRegistrar.getInstancia_local();
		this.login = controladorRegistrar.getLogin();
		this.ventanaCliente.getCampoLogin().setText(login);
		this.ventanaCliente.getBotonEnviar().addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botonEnviarActionPerformed(evt);
			}
		});
		inicializarObjetoRemoto();
		instancia_local.difundirMensaje("User " + login + " enter to chat room!");
		this.ventanaCliente.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				try {
					onExit();
				} catch (java.rmi.RemoteException ex) {
					java.util.logging.Logger.getLogger(ControladorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				}
			}
		});
	}

	@Override
	public void mostrarMensaje(String mensaje) throws java.rmi.RemoteException {
		this.ventanaCliente.getAreaMensajes().append(mensaje + "\n");
		System.out.println("Mensaje recibido de " + mensaje);
	}

	private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {
		String login = this.ventanaCliente.getCampoLogin().getText();
		String mensaje = login + ": " + this.ventanaCliente.getCampoTextoEnviar().getText();
		try {
			instancia_local.difundirMensaje(mensaje);
		} catch (java.rmi.RemoteException ex) {
			java.util.logging.Logger.getLogger(ControladorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		this.ventanaCliente.getCampoTextoEnviar().setText("");
	}

	private final void inicializarObjetoRemoto() {
		try {
			System.setProperty("java.rmi.server.hostname","192.168.1.2");
			java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry();
			String nombre_objeto_remoto = this.ventanaCliente.getCampoLogin().getText();
			registry.rebind(nombre_objeto_remoto, (interfaz.InterfazCliente) this);
			System.out.println("Cliente " + nombre_objeto_remoto);
		} catch (java.rmi.RemoteException ex) {
			java.util.logging.Logger.getLogger(ControladorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	public void onExit() throws java.rmi.RemoteException {
		instancia_local.difundirMensaje("User" + login + " left the chat room!");
		boolean desconectado = instancia_local.desconectar(login);
		if (desconectado) {
			System.out.println("Usuario desconectado");
		}
	}

	public view.VentanaCliente getVentanaCliente() {
		return ventanaCliente;
	}

}
