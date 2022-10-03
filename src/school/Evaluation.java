package school;

public class Evaluation {
	double note;
	double coefficient;
	
	Session session;
	Student student;
	
	public Course getCourse() {
		return session.course;
	}

	public double getCoeff() {
		return coefficient;
	}

	public double computeCoeff() {
		return coefficient * session.course.coefficent;
	}

}
