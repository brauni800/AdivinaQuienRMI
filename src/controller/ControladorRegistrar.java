package controller;

public class ControladorRegistrar {

	private interfaz.InterfazServidor instancia_local;
	private view.VentanaRegistrar ventanaRegistrar;
	private String login;

	public ControladorRegistrar() {
		this.ventanaRegistrar = new view.VentanaRegistrar();
		this.ventanaRegistrar.getBotonEntrar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntrarActionPerformed(evt);
            }
        });
	}

	public void invocarObjetoRemoto() {
		try {
			java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry();
			System.out.print("Buscando el objeto remoto...");
			String nombre_objeto_remoto = "servidor";
			instancia_local = (interfaz.InterfazServidor) registry.lookup(nombre_objeto_remoto);
			System.out.println("Objeto remoto encontrado");
		} catch (java.rmi.RemoteException ex) {
			java.util.logging.Logger.getLogger(ControladorRegistrar.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (java.rmi.NotBoundException ex) {
			java.util.logging.Logger.getLogger(ControladorRegistrar.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	private void botonEntrarActionPerformed(java.awt.event.ActionEvent evt) {
		login = this.ventanaRegistrar.getCampoLogin().getText();
		try {
			String respuesta = instancia_local.registrar(login);
			if (respuesta.equals("usuarioDuplicado")) {
				this.ventanaRegistrar.getCampoNotificaciones().setText("Login Unavailable. Provide another!!.");
			}
			if (respuesta.equals("usuarioAnadido")) {
				ControladorCliente contCliente = new ControladorCliente(this);
				contCliente.getVentanaCliente().setVisible(true);
				this.ventanaRegistrar.setVisible(false);
			}
		} catch (java.rmi.RemoteException ex) {
			java.util.logging.Logger.getLogger(ControladorRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	public interfaz.InterfazServidor getInstancia_local() {
		return instancia_local;
	}

	public String getLogin() {
		return login;
	}

	public view.VentanaRegistrar getVentanaRegistrar() {
		return ventanaRegistrar;
	}
}
