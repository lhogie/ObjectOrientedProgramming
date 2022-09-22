import java.util.function.Predicate;

public class TestInnerAndAnonymousClasses {

	interface A {
		void f();
	}

	static Predicate p1 = new Predicate() {
		@Override
		public boolean test(Object t) {
			return t.toString() == null;
		}
	};

	static Predicate p2 = t -> t.toString() == null;

	static A a = new A() {
		@Override
		public void f() {
			System.out.println("coucou");
		}
	};

	static A b = new A() {
		@Override
		public void f() {
			System.out.println("coucou2");
		}
	};

	public static void main(String[] args) {
		System.out.println(A.class.getName());
		System.out.println(a.getClass().getName());
		System.out.println(b.getClass().getName());

		System.out.println(p1.getClass().getName());
		System.out.println(p2.getClass().getName());
}
}
