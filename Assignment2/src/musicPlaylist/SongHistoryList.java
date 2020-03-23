package musicPlaylist;

public class SongHistoryList {
	  private Song first;
	  public SongHistoryList(){
	    super();
	  }
	  public void addSong(Song s){
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
	  public Song lastListened(){
		  if(this.first.getNext() == null) {
			  return this.first;
		  }
		  Song firstCopy = first;
			while(firstCopy.getNext() != null) {
				first = first.getNext();
			}
		return firstCopy;
	    
	  }
}
