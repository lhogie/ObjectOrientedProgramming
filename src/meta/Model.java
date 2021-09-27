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
		checkMethodNames(rootModule, warnings);
	}

	private static void checkMethodNames(Module module, Consumer<String> warnings) {
		for (var subModule : module.subModules) {
			checkMethodNames(subModule, warnings);
		}
		
		// for each class in the module
		for (var c : module.classes) {
			// iterates over its members
			for (Member member : c.members) {
				// is this member a method or an attribute?
				if (member instanceof Method) {
					// here we know that "member" actually is a method, 
					// hence we can force its cast safely
					Method method = (Method) member;

					// use a regexp to check if the name is correct
					if (!method.name.matches("[a-z_][a-zA-Z0-9_]*")) {
						warnings.accept("bad method name: " + c.name);
					}
				}
			}
		}
	}

	private void checkClassNames(Consumer<String> warnings) {
		for (var c : rootModule.classes) {
			if (!c.name.matches("[A-Z_][a-zA-Z0-9_]*")) {
				warnings.accept("bad class name: " + c.name);
			}
		}
	}
}
