package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazServidor extends Remote {

	public String registrar(String login) throws RemoteException;

	public void difundirMensaje(String mensaje) throws RemoteException;

	public boolean desconectar(String login) throws RemoteException;

}
