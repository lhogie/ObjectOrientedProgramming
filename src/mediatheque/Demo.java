package mediatheque;

public class Demo {
	public static void main(String[] args) {
		var m = new Mediatheque();

		addAlbum("Pink Floyd", RecordType.album, "Dark Side of the Moon", m);
		addAlbum("Beatles", RecordType.album, "Abbey Road", m);

		for (var d : m.records) {
			System.out.println(d);
		}

		var a = m.lookup("Pink Floyd");
		System.out.println(a);

		var pinkFloydDisks = a.findDisks(m);

		System.out.println(pinkFloydDisks);

	}

	private static void addAlbum(String artistName, RecordType diskType, String albumTitle, Mediatheque m) {
		// create a new artist
		var a = new Artist();
		a.setName(artistName);

		// create a new album
		var d = new Record(diskType);
		d.setTitle(albumTitle);

		// create just a virtual mentioning the artist, in order to find the disk
		var virtualTrack = new Track();
		a.works.add(virtualTrack);
		d.tracks.add(virtualTrack);

		// all the tracks of that album were done by the artist
		for (var t : d.tracks) {
			a.works.add(t);
		}

		m.artists.add(a);
		m.records.add(d);
	}

}
