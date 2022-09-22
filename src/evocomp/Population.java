package evocomp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Population<I> {
	final Random prng = new Random();
	List<I> individuals = new ArrayList<>();

	abstract double fitness(I i);

	public void evolve(int nbYears) {
		for (int y = 0; y < nbYears; ++y) {
			// remove poorly fitting individuals
			final int initialSize = individuals.size();

			while (individuals.size() > initialSize / 2) {
				individuals.remove(individuals.size() - 1);
			}

			while (individuals.size() < initialSize) {
				var p1 = individuals.get(prng.nextInt(initialSize/2));
				var p2 = individuals.get(prng.nextInt(initialSize/2));
				var child = crossover(p1, p2);
				
				mutation(child);
				individuals.add(child);
			}
		}
	}

	protected abstract void mutation(I child);

	protected abstract I crossover(I p1, I p2);
}
