package mediatheque;

public class Track extends Work {

	public boolean involve(Artist artist) {
		return artist.getWorks().contains(this);
	}

}
