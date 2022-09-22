package mediatheque;

import java.util.HashSet;
import java.util.Set;

public class Mediatheque {
	String directorName;
	String address;
	
	final Set<Record> records = new HashSet<>();
	final Set<Artist> artists = new HashSet<>();

	public Set<Record> allRecords() {
		return records;
	}
	
	public void addRecord(Record r) {
		records.add(r);
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
