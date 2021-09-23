package meta;

public enum MemberVisibility {
	PUBLIC, // visible from any class
	PROTECTED, // visible from both inside its class, and subclasses
	PRIVATE, // visible from inside its class only
	MODULE; // visible from any class within the same module
}
