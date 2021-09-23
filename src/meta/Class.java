package meta;

import java.util.HashSet;
import java.util.Set;

public class Class extends ModelElement {
	String name;
	final Set<Member> members = new HashSet<>();
	private Module module;

	public Class(Module module, String name) {
		setModule(module);
		this.name = name;
	}

	@Override
	public String toString() {
		String s = "class " + name + " {\n";

		for (var m : members) {
			s += m.toString() + "\n";
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
}
