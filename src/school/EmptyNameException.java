package school;

public class EmptyNameException extends IllegalArgumentException {
	public EmptyNameException() {
		super("empty names are not allowed");
	}
}
