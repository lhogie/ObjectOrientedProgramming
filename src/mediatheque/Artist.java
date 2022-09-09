package mediatheque;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Artist {
	private String name;
	final List<Work> works = new ArrayList<>();

	public Set<Disk> findDisks(Mediatheque m) {
		Set<Disk> disks = new HashSet<>();

		for (var d : m.allDisks()) {
			for (var t : d.tracks) {
				if (t.involve(this)) {
					disks.add(d);
				}
			}
		}

		return disks;
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
