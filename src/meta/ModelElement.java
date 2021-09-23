package meta;

public abstract class ModelElement {
	@Override
	public String toString() {
		return toJava();
	}

	public abstract String toJava();
}
