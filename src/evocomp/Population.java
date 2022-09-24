package evocomp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public abstract class Population<I> {
	final Random prng = new Random();
	List<I> individuals = new ArrayList<>();

	public Mutation<I> mutation;

	public Population(int i) {
		while (individuals.size() < i) {
			individuals.add(createRandomIndividual());
		}
	}

	public int averageFitness() {
		int sum = 0;

		for (var i : individuals) {
			sum += fitness(i);
		}

		return sum / individuals.size();
	}

	protected abstract I createRandomIndividual();

	abstract double fitness(I i);

	public void evolve(int nbYears) {
		for (int y = 0; y < nbYears; ++y) {
			// remove poorly fitting individuals
			final int initialSize = individuals.size();

			while (individuals.size() > initialSize / 2) {
				individuals.remove(individuals.size() - 1);
			}

			while (individuals.size() < initialSize) {
				var p1 = individuals.get(prng.nextInt(initialSize / 2));
				var p2 = individuals.get(prng.nextInt(initialSize / 2));
				var child = crossover(p1, p2);

				if (mutation != null) {
					mutation.mutate(child);
				}

				individuals.add(child);
			}

			Collections.sort(individuals, new Comparator<I>() {

				@Override
				public int compare(I i1, I i2) {
					return Double.compare(fitness(i1), fitness(i2));
				}
			});

//			Collections.sort(individuals, (i1, i2) -> Double.compare(fitness(i1), fitness(i2)));
		}
	}

	protected abstract I crossover(I p1, I p2);

	@Override
	public String toString() {
		return individuals.toString();
	}
}
