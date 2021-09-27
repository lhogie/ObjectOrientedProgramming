package meta;

public class Member extends Declaration {
	public MemberVisibility visibility;
	public boolean isStatic = false;

	public Member(MemberVisibility visibility, boolean isStatic, Class type, String name) {
		super(type, name);
		this.visibility = visibility;
	}

	@Override
	public String toString() {
		String s = "";

		if (isStatic) {
			s += "static ";
		}

		return s + visibility + " " + super.toString();
	}

}
