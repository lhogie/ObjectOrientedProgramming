package school;

public class Person {
	private String name, surname;
	protected final long inseeNumber;

	public Person(long in) {
		this.inseeNumber = in;
	}

	public Person(String name, String surname, long in) {
		this.inseeNumber = in;
		setName(name);
		setSurname(surname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		ensureNameIsNotEmpty(name);
		this.name = name;
	}

	private static void ensureNameIsNotEmpty(String s) {
		if (s.isEmpty())
			throw new EmptyNameException();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		ensureNameIsNotEmpty(name);
		this.surname = surname;
	}

}
