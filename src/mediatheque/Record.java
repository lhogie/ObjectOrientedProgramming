package mediatheque;

import java.util.ArrayList;
import java.util.List;

public class Record extends Titled {
	private RecordType type;
	
	final List<Track> tracks = new ArrayList<>();

	public Record(RecordType type) {
		setType(type);
	}

	public RecordType getType() {
		return type;
	}

	public void setType(RecordType type) {
		if (type == null)
			throw new IllegalArgumentException("you try to set a null disk type");

		this.type = type;
	}

	public Track getTrackAt(int index) {
		return tracks.get(index);
	}

	public int getNbTracks() {
		return tracks.size();
	}

	public void addTrack(Track t) {
		if (t == null)
			throw new IllegalArgumentException("you try to insert a null track");

		tracks.add(t);
	}

	@Override
	public String toString() {
		return getTitle() + " (" + type + ", " + tracks.size() + " tracks)";
	}
}
