package data_structures.linked_list;

public class SimplyLinkedList extends L3IAList {

	private int size = 0;
	private Cell first;

	public int size() {
		return size;
	}

	@Override
	public void add(Object o, int pos) {
		if (pos < 0 || pos > size)
			throw new IllegalArgumentException("out of bounds");

		if (pos == 0) {
			first = new Cell(o);
		} else if (pos == size) {
			Cell c = cellAt(pos);
			var newCell = new Cell(o);
			c.next = newCell;
		} else {
			Cell c = cellAt(pos - 1);
			var newCell = new Cell(o);
			newCell.next = c.next;
			c.next = newCell;
		}

		++size;
	}

	private Cell cellAt(int pos) {
		if (pos < 0 || pos > size)
			throw new IllegalArgumentException("out of bounds");

		Cell c = first;

		for (int i = 0; i < pos; ++i) {
			c = c.next;
		}

		return c;
	}

	@Override
	public void remove(int pos) {
		if (pos < 0 || pos > size)
			throw new IllegalArgumentException("out of bounds");

		if (pos == 0) {
			first = first.next;
		} else {
			Cell c = cellAt(pos - 1);
			c.next = c.next.next;
		}

		--size;
	}

	@Override
	public int indexOf(Object o, int start) {
		Cell c = cellAt(start);

		for (int i = start; i < size; ++i) {
			if (c.value.equals(o)) {
				return i;
			}

			c = c.next;
		}

		return -1;
	}

	@Override
	public void set(Object o, int i) {
		cellAt(i).value = o;
	}

	@Override
	public Object get(int i) {
		return cellAt(i).value;
	}

	@Override
	public String toString() {
		if (first == null)
			return "";

		String s = "";

		for (Cell c = first; c.next != null; c = c.next) {
			s += c.value;

			if (c.next != null) {
				s += ", ";
			}
		}

		return s;
	}
}
