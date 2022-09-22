package mediatheque;

public class Work extends Titled {
	// the EPOC day of the release
	public long date;

	public boolean involve(Artist artist) {
		return artist.getWorks().contains(this);
	}
}
