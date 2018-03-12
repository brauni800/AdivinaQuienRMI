package view;

@SuppressWarnings("serial")
public class PanelJanKenPo extends javax.swing.JPanel {

	private javax.swing.JLabel piedra, papel, tijera;
	
	public PanelJanKenPo() {
		setBackground(java.awt.Color.CYAN);
		initComponents();
	}

	private void initComponents() {
    	setBounds(0, 0, 450, 300);
    	setLayout(null);
    	setVisible(true);
    	
    	piedra = new javax.swing.JLabel("");
    	piedra.setBounds(10, 50, 144, 130);
    	javax.swing.ImageIcon piedraImage = new javax.swing.ImageIcon(getClass().getResource("/images/piedra.png"));
    	javax.swing.Icon piedraIcono = new javax.swing.ImageIcon(piedraImage.getImage().getScaledInstance(piedra.getWidth(), piedra.getHeight(), java.awt.Image.SCALE_DEFAULT));
		piedra.setIcon(piedraIcono);
    	add(piedra);
    	
    	papel = new javax.swing.JLabel("");
    	papel.setBounds(150, 50, 144, 130);
    	javax.swing.ImageIcon papelImage = new javax.swing.ImageIcon(getClass().getResource("/images/papel.png"));
    	javax.swing.Icon papelIcono = new javax.swing.ImageIcon(papelImage.getImage().getScaledInstance(papel.getWidth(), papel.getHeight(), java.awt.Image.SCALE_DEFAULT));
		papel.setIcon(papelIcono);
    	add(papel);
    	
    	tijera = new javax.swing.JLabel("");
    	tijera.setBounds(290, 50, 144, 130);
    	javax.swing.ImageIcon tijeraImage = new javax.swing.ImageIcon(getClass().getResource("/images/tijeras.png"));
    	javax.swing.Icon tijeraIcono = new javax.swing.ImageIcon(tijeraImage.getImage().getScaledInstance(tijera.getWidth(), tijera.getHeight(), java.awt.Image.SCALE_DEFAULT));
		tijera.setIcon(tijeraIcono);
    	add(tijera);
    	
    	
	}

	public javax.swing.JLabel getPiedra() {
		return piedra;
	}

	public javax.swing.JLabel getPapel() {
		return papel;
	}

	public javax.swing.JLabel getTijera() {
		return tijera;
	}
	
}
