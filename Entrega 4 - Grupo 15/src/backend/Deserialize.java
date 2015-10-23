package backend;
import java.io.*;

public class Deserialize {
	

	 public static void deserialize(SistemaEncomienda s)
	   {
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("/tmp/sistema.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         s = (SistemaEncomienda) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
}
}
