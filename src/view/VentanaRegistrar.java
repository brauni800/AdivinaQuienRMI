package view;

@SuppressWarnings("serial")
public class VentanaRegistrar extends javax.swing.JFrame {
	
	private javax.swing.JButton botonEntrar;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JLabel titulo, encabezado, campoNotificaciones;
    
    public VentanaRegistrar() {
        initComponents();
    }
    
    private void initComponents() {
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    	setSize(450, 300);
    	setResizable(false);
    	getContentPane().setLayout(null);
    	
    	encabezado = new javax.swing.JLabel();
    	encabezado.setBounds(145, 35, 133, 14);
    	encabezado.setText("GOTY");
    	getContentPane().add(encabezado);
    	
    	titulo = new javax.swing.JLabel();
    	titulo.setBounds(145, 80, 133, 14);
    	titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    	titulo.setText("LOGIN");
    	getContentPane().add(titulo);
    	
    	campoNotificaciones = new javax.swing.JLabel();
    	campoNotificaciones.setBounds(145, 170, 0, 0);
    	campoNotificaciones.setText("");
    	getContentPane().add(campoNotificaciones);
    	
    	campoLogin = new javax.swing.JTextField();
    	campoLogin.setBounds(145, 105, 133, 25);
    	getContentPane().add(campoLogin);
    	
    	botonEntrar = new javax.swing.JButton();
    	botonEntrar.setBounds(145, 136, 133, 25);
    	botonEntrar.setText("Play");
    	getContentPane().add(botonEntrar);
    }

	public javax.swing.JButton getBotonEntrar() {
		return botonEntrar;
	}

	public javax.swing.JTextField getCampoLogin() {
		return campoLogin;
	}

	public javax.swing.JLabel getTitulo() {
		return titulo;
	}

	public javax.swing.JLabel getEncabezado() {
		return encabezado;
	}

	public javax.swing.JLabel getCampoNotificaciones() {
		return campoNotificaciones;
	}
}
