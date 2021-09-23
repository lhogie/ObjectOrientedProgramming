package meta;

import java.util.HashSet;
import java.util.Set;

public class Class extends ModelElement {
	public static final Class number = new Class(null, "int");
	public static final Class string = new Class(null, "string");
	public static final Class list = new Class(null, "list");
	public static final Class set = new Class(null, "set");

	String name;
	final Set<Member> members = new HashSet<>();
	private Module module;

	public Class(Module module, String name) {
		setName(name);
		setModule(module);
	}

	public void setName(String newName) {
		if (!newName.matches("[A-Za-z_]+"))
			throw new IllegalArgumentException();

		this.name = newName;
	}

	@Override
	public String toString() {
		String s = "class " + name + " {\n";

		for (var m : members) {
			s += "\t" + m.toString() + "\n";
		}

		s += "}";
		return s;
	}

	public void setModule(Module m) {
		module = m;

		if (m != null) {
			module.classes.add(this);
		}
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object m) {
		return name.equals(((Class) m).name);
	}

}
