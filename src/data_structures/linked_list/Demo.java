package data_structures.linked_list;

public class Demo {
	public static void main(String[] args) {
		L3IAList l = new SimplyLinkedList();

		for (int i = 0; i < 100; ++i) {
			System.out.println(l.size());
			System.out.println(l);

			l.add("hello" + i, 0);
		}

	}

}
