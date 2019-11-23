package principal;

import java.rmi.RemoteException;

import controller.AutenticacionController;
import controller.AutenticacionControllerProxy;

public class TestAutenticar {

	public static void main(String[] args) throws RemoteException {
		String user="test1";
		String pass="test1";
		
//		DECLARAMOS LA VARIABLE DE LA INTERFAZ
		AutenticacionController px;
		
//		INSTANCIAMOS LA CLASE QUE IMPLEMENTA LA INTERFAZ, QUE TERMINA EN PROXY
		AutenticacionControllerProxy proxy=new AutenticacionControllerProxy();
		
//		LE PEDIMOS LA IMPLEMENTACION DE LA INTERFAZ
		px=proxy.getAutenticacionController();
		
//		PODEMOS USAR SUS METODOS NORMALMENTE
		if(px.autenticar(user, pass)) {
			System.out.println("El usuario existe");
		} else {
			System.out.println("El usuario NO existe");
		}
	}
}
