package musicPlaylist;

public class Song {
	private String track;
	private Song next;
	

	public Song() {
		super();
	}
	
	public Song(String track) {
		super();
		this.track = track;
	}
	
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public Song getNext() {
		return next;
	}
	public void setNext(Song next) {
		this.next = next;
	}
	
	
}
