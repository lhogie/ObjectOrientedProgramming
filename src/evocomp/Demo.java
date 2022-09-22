package evocomp;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		var p = new Population<String>() {

			@Override
			double fitness(String s) {
				if (s.length() == 16) {
					return 1;
				}

				return 0;
			}

			@Override
			protected String crossover(String p1, String p2) {
				

				return null;
			}

			@Override
			protected void mutation(String child) {
				
			}
		};
	}
}
