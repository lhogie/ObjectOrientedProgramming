package serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SWrite {
	public static void main(String[] args) {
		try {
			var out = new ObjectOutputStream(System.out);
			var l = List.of(args);
			l = new ArrayList<>(l);
			out.writeObject(l);
		} catch (IOException e) {
			System.err.println("you got an I/O error");
		}

	}
}
