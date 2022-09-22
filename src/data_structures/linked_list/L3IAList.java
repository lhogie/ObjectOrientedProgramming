package data_structures.linked_list;

public abstract class L3IAList {
	public boolean isEmpty() {
		return size() == 0;
	}

	public void clear() {
		while (!isEmpty()) {
			remove(0);
		}
	}

	public abstract int size();

	public abstract void add(Object o, int pos);

	public abstract void remove(int pos);

	public abstract int indexOf(Object o, int start);

	public abstract void set(Object o, int i);

	public abstract Object get(int i);

}
