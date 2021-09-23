package meta;

public class Member extends Declaration {
	public Member(MemberVisibility visibility, Class type, String name) {
		super(type, name);
		this.visibility = visibility;
	}

	public MemberVisibility visibility;

	@Override
	public String toJava() {
		return visibility + " " + super.toJava();
	}

}
