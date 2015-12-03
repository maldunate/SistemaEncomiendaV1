package backend;
import java.io.*;
import java.util.ArrayList;

public class Deserialize {
		      
	      public static ArrayList<Sucursal> deserializeListaSucursales(ArrayList<Sucursal> s)
		   {
		      try
		      {
		    		FileInputStream fis = new FileInputStream("listaSucursales.ser");
		    		ObjectInputStream oin = new ObjectInputStream(fis);
		    		ArrayList<Sucursal> readObject = (ArrayList<Sucursal>) oin.readObject();
					s = readObject;
		    		//System.out.println("version="+ts.version);
		    		oin.close();
		    		fis.close();
		    		return s;

		      }catch(IOException i)
		      {
		         i.printStackTrace();
		         return new ArrayList<>();
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("SistemaEncomienda class not found");
		         c.printStackTrace();
		         return new ArrayList<>();
		      }
		   }
	      
	      public static ArrayList<Cliente> deserializeListaClientes(ArrayList<Cliente> s)
		   {
		      try
		      {
		    		FileInputStream fis = new FileInputStream("listaClientes.ser");
		    		ObjectInputStream oin = new ObjectInputStream(fis);
		    		ArrayList<Cliente> readObject = (ArrayList<Cliente>) oin.readObject();
					s = readObject;
		    		//System.out.println("version="+ts.version);
		    		oin.close();
		    		fis.close();
		    		return s;

		      }catch(IOException i)
		      {
		         i.printStackTrace();
		         return new ArrayList<>();
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("SistemaEncomienda class not found");
		         c.printStackTrace();
		         return new ArrayList<>();
		      }
		   }
	      
	      public static ArrayList<Pedido> deserializeListaPedidos(ArrayList<Pedido> s)
		   {
		      try
		      {
		    		FileInputStream fis = new FileInputStream("listaPedidos.ser");
		    		ObjectInputStream oin = new ObjectInputStream(fis);
		    		ArrayList<Pedido> readObject = (ArrayList<Pedido>) oin.readObject();
					s = readObject;
		    		//System.out.println("version="+ts.version);
		    		oin.close();
		    		fis.close();
		    		return s;

		      }catch(IOException i)
		      {
		         i.printStackTrace();
		         return new ArrayList<>();
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("SistemaEncomienda class not found");
		         c.printStackTrace();
		         return new ArrayList<>();
		      }
		   }
}

