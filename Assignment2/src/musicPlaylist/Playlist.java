package musicPlaylist;

public class Playlist {
	private Song first;
	
	public Playlist() {
		super();
	}
	
	public void addSong(Song s) {
		if(this.first == null) {
			this.first=s;
			return;
		}
		
		Song firstCopy = first;
		
		while(this.first.getNext() != null) {
			first = first.getNext();
		}
		
		first.setNext(s);
		
		this.first = firstCopy;
			
	}
	
	public Song listenToSong() {
		return this.first.getNext();
	}
}
