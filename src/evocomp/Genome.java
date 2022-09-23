package evocomp;

import java.util.ArrayList;

public abstract class Genome<E> extends ArrayList<E> {
	public abstract Individual toIndividual();
}
