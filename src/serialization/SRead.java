package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SRead {
	public static void main(String[] args) {
		try {
			var in = new ObjectInputStream(System.in);
			var o = in.readObject();
			System.out.println("the class of the received object is: " + o.getClass().getName());
			System.out.println(o);
			System.out.println("is a list?" + (o instanceof List));
		} catch (IOException e) {
			System.err.println("you got an I/O error");
		} catch (ClassNotFoundException e) {
			System.err.println("you asked me a class I don't know!!!!!");
		}
		
	}
}
