package meta;

public class Demo {
	public static void main(String[] args) {
		Model model = new Model();
		model.rootModule.subModules.add(new Module("module2"));
		model.rootModule.subModules.add(new Module("yet another module"));

		var c1 = new Class(model.rootModule, "Class");
		c1.members.add(new Attribute(MemberVisibility.PRIVATE, false, Class.number, "someNumber"));
		c1.members.add(new Attribute(MemberVisibility.MODULE, false, Class.string, "someName"));
		c1.members.add(new Attribute(MemberVisibility.PUBLIC, true, Class.string, "A_CONSTANT"));
		var m = new Method(MemberVisibility.MODULE, false, Class.string, "f");
		m.parms.add(new Declaration(Class.number, "parameter1"));
		m.parms.add(new Declaration(Class.list, "parameter2"));
		c1.members.add(m);

		model.check(w -> System.out.println(w));
		System.out.println(model);
	}
}
