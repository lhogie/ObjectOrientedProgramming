package meta;

import java.util.ArrayList;
import java.util.List;

public class Method extends Member {

	final public List<Declaration> parms = new ArrayList<>();
	final public List<Class> exceptions = new ArrayList<>();

	public Method(MemberVisibility visibility, boolean isStatic, Class type, String name) {
		super(visibility, isStatic, type, name);
	}

	@Override
	public String toString() {
		String s = super.toString() + "(" + Utils.list(parms, p -> p.toString()) + ")";

		if (!exceptions.isEmpty()) {
			s += "\n\tthrows " + Utils.list(exceptions, e -> e.toString());
		}

		return s;
	}
}
