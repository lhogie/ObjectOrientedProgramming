package meta;

import java.util.function.Consumer;

public class Model {
	public String description;
	public Module rootModule = new Module("");

	@Override
	public String toString() {
		String s = "model name: " + description;
		return s + "\n" + rootModule.toString();
	}
	
	public void check(Consumer<String> warnings) {
		checkClassNames(warnings);
		checkMethodNames(warnings);
	}

	private void checkMethodNames(Consumer<String> warnings) {
		// do it yourself
	}

	private void checkClassNames(Consumer<String> warnings) {
		for (var c : rootModule.classes) {
			if (!c.name.matches("[A-Z_][A-Z0-9_]*")) {
				warnings.accept("bad class name: " + c.name);
			}
		}
	}
}
