package evocomp;

import java.util.Random;

// a composite mutation

public class EquiprobableMutations<I> extends CompositeMutation<I> {

	@Override
	public void mutate(I child) {
		Random prng = new Random();
		var randomMutation = mutations.get(prng.nextInt(mutations.size()));
		randomMutation.mutate(child);
	}
}
