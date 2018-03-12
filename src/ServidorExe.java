
public class ServidorExe {

	public static void main(String[] args) throws java.rmi.RemoteException {
		controller.Servidor server = new controller.Servidor();
        server.inicializarObjetoRemoto();
	}
}
