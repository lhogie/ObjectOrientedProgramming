package mediatheque;

public class Titled {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null)
			throw new NullPointerException("can't set a title to null");

		if (title.isEmpty())
			throw new IllegalArgumentException("empty titles are not allowed");

		this.title = title;
	}
}
