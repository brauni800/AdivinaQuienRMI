
public class RegistrarExe {

	public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	controller.ControladorRegistrar contRegistrar =  new controller.ControladorRegistrar();
            	contRegistrar.getVentanaRegistrar().setVisible(true);
            	contRegistrar.invocarObjetoRemoto();
            }
        });
	}
}
