package meta;

public class Declaration extends ModelElement {
	public String name;
	public Class type;
	public boolean isFinal = false;

	public Declaration(Class type, String name) {
		this.type = type;
		this.name = name;
	}

	@Override
	public String toString() {
		String s = "";

		if (isFinal) {
			s += "final ";
		}

		return s + type.name + " " + name;
	}
}
