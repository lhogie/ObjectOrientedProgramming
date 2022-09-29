package school;

public class Evaluation {
	double note;
	double coefficient;
	
	Session session;
	Student student;
	
	public Course getCourse() {
		return session.getCourse();
	}
}
