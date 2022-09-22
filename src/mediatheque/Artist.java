package mediatheque;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Artist {
	private String name;
	final List<Work> works = new ArrayList<>();
	private Set<Record> recordCache;
	
	
	public Set<Record> findDisks(Mediatheque m) {
		if (recordCache == null) {
			recordCache = new HashSet<>();

			for (var d : m.allRecords()) {
				for (var t : d.tracks) {
					if (t.involve(this)) {
						recordCache.add(d);
					}
				}
			}
		}

		return recordCache;
	}

	public List<Work> getWorks() {
		return works;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
