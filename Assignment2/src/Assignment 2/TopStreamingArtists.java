package Assignment2;

public class TopStreamingArtists {

	private Artist first;
	public TopStreamingArtists() {
		this.first=null;
	}
	public Artist getFirst() {
		return first;
	}
	public void insert(String artistName) {
//		if(this.first == null) {
//			this.first = new Artist(artistName);
//		} else {
//			
//			Artist top = this.first;
//			Artist pointTop = top;
//			while(top !=null) {
//				if(top.name.compareTo(artistName) > 0) {
//					Artist tempTop = new Artist(top.name);
//					top.name = artistName;
//					top.next = tempTop;
//				} else if (top.name.compareTo(artistName) < 0) {
//					top = top.next;
//				}
//			}
//			top = new Artist(artistName);
//			this.first = pointTop;
//		}
		if(this.first == null) {
			this.first = new Artist(artistName);
		} else {
			
			Artist top = this.first;
			Artist pointTop = top;
			while(top.next != null) {
				top = top.next;
			}
			top.next = new Artist(artistName);
		}
		
	
	}
	
	public void displayOrderedList() {
		Artist top = this.first;
		while(top != null) {
			System.out.println(top.name);
			top = top.next;
		}
	}
	
	
}
