package evocomp;

public class PasswordGenerator {

	public static void main(String[] args) {
		var p = new Population<StringBuilder>(100) {

			@Override
			double fitness(StringBuilder s) {
				int d = Math.abs(16 - s.length());
				return 1d / (d + 1);
			}

			@Override
			protected StringBuilder crossover(StringBuilder p1, StringBuilder p2) {
				StringBuilder r = new StringBuilder();
				r.append(p1.substring(p1.length() / 2));
				r.append(p2.substring(p2.length() / 2, p2.length()));
				return r;
			}

			static final String alphabet = "$oîpoiuytjrhsefgxchjvbkp^$oiàuçùylj;cg snkmjopi";

			@Override
			protected StringBuilder createRandomIndividual() {
				int len = prng.nextInt(16) + 1;
				var b = new StringBuilder();

				while (b.length() < len) {
					int randomI = prng.nextInt(alphabet.length());
					char randomChar = alphabet.charAt(randomI);
					b.append(randomChar);
				}

				return b;
			}
		};

		CompositeMutation<StringBuilder> m = new EquiprobableMutations<>();

		// remove char
		m.mutations.add(s -> s.deleteCharAt(p.prng.nextInt(s.length())));

		// add char
		m.mutations.add(s -> s.append(p.alphabet.charAt(p.prng.nextInt(p.alphabet.length()))));

		// alter a particular char
		m.mutations.add(
				s -> s.setCharAt(p.prng.nextInt(s.length()), p.alphabet.charAt(p.prng.nextInt(p.alphabet.length()))));

		p.mutation = m;

		System.out.println("population is : " + p);
		System.out.println("average fitness: " + p.averageFitness());

		p.evolve(100);

		System.out.println("population is : " + p);
		System.out.println("average fitness: " + p.averageFitness());
	}
}
