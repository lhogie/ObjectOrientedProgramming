package school;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StudentClass implements Iterable<Student> {
	 final Set<Student> students = new HashSet<>();
	public final Set<Student> unmodifiableStudentSet = Collections.unmodifiableSet(students);
	Parcours parcours;
	String id;

	// DO NOT USE
	// FOR SERIALIZATION ONLY
	public StudentClass() {

	}

	public StudentClass(Set<Student> initialStudents) {
		if (initialStudents.isEmpty())
			throw new IllegalArgumentException();

		students.addAll(initialStudents);
	}

	public StudentClass(Student[] initialStudents) {
		students.addAll(List.of(initialStudents));
	}

	public void addStudent(Student s) {
		s.studentClass = this;
		students.add(s);
	}

	public void removeStudent(Student s) {
		s.studentClass = null;
		students.remove(s);
	}

	@Override
	public Iterator<Student> iterator() {
		return students.iterator();
	}

	public boolean containsStudentName(String surname) {
		for (var s : this) {
			if (s.getSurname().equals(surname)) {
				return true;
			}
		}

		return false;
	}

	public boolean containsStudentName_OLD_FASHION(String surname) {
		Iterator<Student> i = iterator();

		while (i.hasNext()) {
			Student s = i.next();

			if (s.getSurname().equals(surname)) {
				return true;
			}
		}

		return false;
	}

}
