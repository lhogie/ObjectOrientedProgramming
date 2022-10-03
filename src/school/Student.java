package school;

import java.util.HashSet;
import java.util.Set;

public class Student extends Person { // IS A
	private int ID;
	final Set<Evaluation> evaluations = new HashSet<>();
	StudentClass studentClass;

	public Student(int id, long insee) {
		super(insee);
		this.ID = id;
	}

	public void setClass(StudentClass c) {
		if (c.students.contains(this))
			throw new IllegalArgumentException("student already in this class");

		// if the student is already in a class
		if (studentClass != null) {
			// unregister him from this class
			studentClass.students.remove(this);
		}

		// set the new class
		c.students.add(this);
		this.studentClass = c;
	}

	public Set<Course> evaluatedCourses() {
		var courses = new HashSet<Course>();

		for (var e : evaluations) {
			courses.add(e.session.course);
		}

		return courses;
	}

	public double getMean() {
		if (evaluations.isEmpty())
			throw new IllegalStateException("can not compute mean from no notes");

		double sum = 0;
		double sumC = 0;

		for (var e : evaluations) {
			var c = e.computeCoeff();
			sum += e.note * c;
			sumC += c;
		}

		return sum / sumC;
	}

	public double getMean(Course c) {
		if (c == null)
			throw new NullPointerException();

		double sum = 0;
		double sumC = 0;

		for (var e : evaluations) {
			if (e.session.course == c) {
				sum += e.note * e.coefficient;
				sumC += e.coefficient;
			}
		}

		return sum / sumC;
	}
}
