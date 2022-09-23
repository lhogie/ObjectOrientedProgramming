package evocomp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// a composite mutation

public class ApplyOneBaseMutation<I> implements Mutation<I> {
	List<Mutation<I>> mutations = new ArrayList<>();

	public ApplyOneBaseMutation(List<Mutation<I>> baseMutations) {
		if (baseMutations == null)
			throw new NullPointerException();

		if (baseMutations.isEmpty())
			throw new IllegalArgumentException("you proposed me NO base mutation, I need at least one");

		this.mutations = baseMutations;
	}

	@Override
	public I mute(I child) {
		Random prng = new Random();
		var randomMutation = mutations.get(prng.nextInt(mutations.size()));
		return randomMutation.mute(child);
	}
}
