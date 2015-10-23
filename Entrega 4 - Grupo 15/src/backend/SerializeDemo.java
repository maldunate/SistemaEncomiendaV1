package backend;
import java.io.*;

public class SerializeDemo {
	public static void serialize(SistemaEncomienda s)
	   {  
	      try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("/tmp/sistema.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(s);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/sistema.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	   }
}
