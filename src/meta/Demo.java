package meta;

public class Demo {
	public static void main(String[] args) {
		var m1 = new Module();
		var m2 = new Module();
		var m3 = new Module();

		Class number = new Class(null, "int");
		Class string = new Class(null, "string");
		Class list = new Class(null, "list");
		Class set = new Class(null, "set");

		var c1 = new Class(m1, "aClass");
		c1.members.add(new Attribute(MemberVisibility.PRIVATE, number, "someNumber"));
		c1.members.add(new Attribute(MemberVisibility.MODULE, string, "someName"));
		var m  =new Method(MemberVisibility.MODULE, string, "f");
		m.parms.add(new Declaration(number, "parameter1"));
		m.parms.add(new Declaration(list, "parameter2"));
		c1.members.add(m);
		
		System.out.println(m1);
	}
}
