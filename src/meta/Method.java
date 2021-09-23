package meta;

import java.util.ArrayList;
import java.util.List;

public class Method extends Member {

	final public List<Declaration> parms = new ArrayList<>();

	public Method(MemberVisibility visibility, Class type, String name) {
		super(visibility, type, name);
	}

	public Method(MemberVisibility visibility, Class returnType, String name, Class c, String n) {
		this(visibility, returnType, name);
		parms.add(new Declaration(c, n));
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

		return s + ")";
	}
}
