package mediatheque;

import java.util.HashSet;
import java.util.Set;

public class Mediatheque {
	String directorName;
	String address;
	
	final Set<Disk> disks = new HashSet<>();
	final Set<Artist> artists = new HashSet<>();

	public Set<Disk> allDisks() {
		return disks;
	}

	public Artist lookup(String artistName) {
		if (artistName == null)
			throw new NullPointerException();
		
		for (var a : artists) {
			// if we have found the artist
			if (a.getName().equals(artistName)) {
				return a;
			}
		}

		return null;
	}
}
