package meta;

public class Demo {
	public static void main(String[] args) {
		var m1 = new Module();
		var m2 = new Module();
		var m3 = new Module();

		var c1 = new Class(m1, "aClass");
		c1.members.add(new Attribute(MemberVisibility.PRIVATE, false, Class.number, "someNumber"));
		c1.members.add(new Attribute(MemberVisibility.MODULE, false, Class.string, "someName"));
		c1.members.add(new Attribute(MemberVisibility.PUBLIC, true, Class.string, "A_CONSTANT"));
		var m = new Method(MemberVisibility.MODULE, false, Class.string, "f");
		m.parms.add(new Declaration(Class.number, "parameter1"));
		m.parms.add(new Declaration(Class.list, "parameter2"));
		c1.members.add(m);

		System.out.println(m1);
	}
}
