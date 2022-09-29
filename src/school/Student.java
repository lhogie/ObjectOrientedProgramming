package school;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student extends Person { // IS A
	private int ID;
	final Set<Evaluation> evaluations = new HashSet<>();

	public Student(int id, long insee) {
		super(insee);
		this.ID = id;
	}

	public double getMean() {
		if (evaluations.isEmpty())
			throw new IllegalStateException("can not compute mean from no note");
		
		double sum = 0;
		double sumC = 0;

		for (var e : evaluations) {
			sum += e.note * e.coefficient;
			sumC += e.coefficient;
		}

		return sum / sumC;
	}
}
