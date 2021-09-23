package meta;

public class Member extends Declaration {
	public MemberVisibility visibility;
	public boolean isStatic = false;

	public Member(MemberVisibility visibility, boolean isStatic, Class type, String name) {
		super(type, name);
		this.visibility = visibility;
		this.isStatic = isStatic;
	}

	@Override
	public String toJava() {
		String s = "";

		if (isStatic) {
			s += "static ";
		}

		return s + visibility + " " + super.toJava();
	}

}
