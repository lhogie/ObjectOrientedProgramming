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
	public String toJava() {
		String s = super.toJava() + "(";

		for (int i = 0; i < parms.size(); ++i) {
			s += parms.get(i).toJava();

			if (i < parms.size() - 1) {
				s += ", ";
			}
		}

		s += s + ")";

		if (!exceptions.isEmpty()) {
			s += "\n\tthrows ";

			for (int i = 0; i < exceptions.size(); ++i) {
				s += exceptions.get(i).name;

				if (i < exceptions.size() - 1) {
					s += ", ";
				}
			}
		}

		return s;
	}
}
