package meta;

import java.util.HashSet;
import java.util.Set;

public class Module extends ModelElement {
	String name;
	final Set<Class> classes = new HashSet<>();
	final  Set<Module> subModules = new HashSet<>();
	private Module parent;
	
	public Module(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		String s = "module " + name + " {\n";

		for (var c : classes) {
			s += Utils.tabulate(c.toString(), 1) + "\n";
		}

		for (var m : subModules) {
			s += Utils.tabulate(m.toString(), 1) + "\n";
		}

		s += "}";
		return s;
	}

	public void setParent(Module m) {
		parent = m;
		parent.subModules.add(this);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object m) {
		return name.equals(((Module) m).name);
	}
}
