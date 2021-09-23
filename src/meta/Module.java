package meta;

import java.util.HashSet;
import java.util.Set;

public class Module extends ModelElement {
	String name;
	final Set<Class> classes = new HashSet<>();
	final private Set<Module> subModules = new HashSet<>();
	private Module parent;

	@Override
	public String toJava() {
		String s = "module " + name + " {\n";

		for (var c : classes) {
			s += c.toJava() + "\n";
		}

		for (var m : subModules) {
			s += m.toJava() + "\n";
		}

		s += "}";
		return s;
	}

	public void setParent(Module m) {
		parent = m;
		parent.subModules.add(this);
	}
}
