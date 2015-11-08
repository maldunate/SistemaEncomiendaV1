package backend;
import java.io.*;
import java.util.ArrayList;

public class SerializeDemo {

	public static void serializeListaSucursales(ArrayList<Sucursal> s){
		try{
		FileOutputStream fos = new FileOutputStream("listaSucursales.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//TestSerial ts = new TestSerial();
		oos.writeObject(s);
		oos.flush();
		oos.close();
		fos.close();
		} catch (IOException i)
		{
			i.printStackTrace();
		}
	}
	
	public static void serializeListaClientes(ArrayList<Cliente> s){
		try{
		FileOutputStream fos = new FileOutputStream("listaClientes.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//TestSerial ts = new TestSerial();
		oos.writeObject(s);
		oos.flush();
		oos.close();
		fos.close();
		} catch (IOException i)
		{
			i.printStackTrace();
		}
	}
	
	public static void serializeListaPedidos(ArrayList<Pedido> s){
		try{
		FileOutputStream fos = new FileOutputStream("listaPedidos.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//TestSerial ts = new TestSerial();
		oos.writeObject(s);
		oos.flush();
		oos.close();
		fos.close();
		} catch (IOException i)
		{
			i.printStackTrace();
		}
	}
}
