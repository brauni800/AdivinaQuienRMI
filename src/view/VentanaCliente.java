package view;

@SuppressWarnings("serial")
public class VentanaCliente extends javax.swing.JFrame {

	private javax.swing.JTextArea areaMensajes;
	private javax.swing.JButton botonEnviar;
	private javax.swing.JLabel campoLogin;
	private javax.swing.JTextField campoTextoEnviar;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel panel;
	
	public VentanaCliente() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setSize(450, 300);
		setResizable(false);
		getContentPane().setLayout(null);
		
		areaMensajes = new javax.swing.JTextArea();
		areaMensajes.setEditable(false);
		areaMensajes.setColumns(20);
		areaMensajes.setRows(5);
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBounds(10, 40, 424, 189);
		jScrollPane1.setViewportView(areaMensajes);
		getContentPane().add(jScrollPane1);
		
		campoTextoEnviar = new javax.swing.JTextField();
		campoTextoEnviar.setBounds(10, 240, 313, 20);
		getContentPane().add(campoTextoEnviar);
		
		botonEnviar = new javax.swing.JButton();
		botonEnviar.setBounds(333, 240, 101, 20);
		botonEnviar.setText("Enviar");
		getContentPane().add(botonEnviar);
		
		campoLogin = new javax.swing.JLabel();
		campoLogin.setBounds(10, 11, 141, 18);
		getContentPane().add(campoLogin);
	}

	public javax.swing.JTextArea getAreaMensajes() {
		return areaMensajes;
	}

	public javax.swing.JButton getBotonEnviar() {
		return botonEnviar;
	}

	public javax.swing.JLabel getCampoLogin() {
		return campoLogin;
	}

	public javax.swing.JTextField getCampoTextoEnviar() {
		return campoTextoEnviar;
	}

	public javax.swing.JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}
	
	public javax.swing.JPanel getPanel() {
		return panel;
	}

	public void setPanel(javax.swing.JPanel panel) {
		this.panel = panel;
		getContentPane().add(this.panel);
	}
}
