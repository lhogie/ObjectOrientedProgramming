package meta;

import java.util.List;
import java.util.function.Function;

public class Utils {
	public static <E> String list(List<E> l, Function<E, String> f) {
		String s = "";

		for (int i = 0; i < l.size(); ++i) {
			var e = l.get(i);
			s += f.apply(e);

			if (i < l.size() - 1) {
				s += ", ";
			}
		}

		return s;
	}

	public static String tabulate(String s, int tabs) {
		var prefix = "\t".repeat(tabs);
		return prefix + s.replace("\n", "\n" + prefix);
	}
}
