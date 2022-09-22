package data_structures.btree;

public class Node<V extends Comparable<V>> {
	V value;
	Node<V> left, right, parent;

	public void add(V e) {
		if (e == null)
			throw new IllegalArgumentException("can't compare null elements");

		var n = new Node<V>();
		n.value = e;
		add(n);
	}

	private void add(Node<V> n) {
		int c = value.compareTo(n.value);

		if (c < 0) {
			if (left == null) {
				left = n;
			} else {
				left.add(n);
			}
		} else if (c > 0) {
			if (right == null) {
				right = n;
			} else {
				right.add(n);
			}
		} else {
			throw new IllegalArgumentException("already in");
		}
	}

	/**
	 * Removes the node containing value "e" and ALL of its children nodes.
	 * 
	 * @param e
	 */
	public boolean removeBranch(V e) {
		Node<V> n = findNode(e);

		// if no such element was found in the tree
		if (n == null) {
			return false;
		} else {
			if (n.parent.left == this) {
				n.parent.left = null;
			} else if (n.parent.right == this) {
				n.parent.right = null;
			} else {
				throw new IllegalStateException("error in tree");
			}

			n.parent = null;
			return true;
		}
	}

	private Node<V> findNode(V e) {
		int c = value.compareTo(e);

		if (c < 0) {
			if (left == null) {
				return null;
			} else {
				return left.findNode(e);
			}

		} else if (c > 0) {
			if (right == null) {
				return null;
			} else {
				return right.findNode(e);
			}
		} else {
			return this;
		}
	}

	public int depth() {
		return 1 + Math.max(left == null ? 0 : left.depth(), right == null ? 0 : right.depth());
	}

	public int nbNodes() {
		return 1 + (left == null ? 0 : left.nbNodes()) + (right == null ? 0 : right.nbNodes());
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

}
