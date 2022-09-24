package evocomp;

import java.util.ArrayList;
import java.util.List;

// a composite mutation

public abstract class CompositeMutation<I> implements Mutation<I> {
	public final List<Mutation<I>> mutations = new ArrayList<>();

}
