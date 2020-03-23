package Assignment2;

public class Artist {

	String name;
	Artist next;
	
	public Artist(String name, Artist next) {
		super();
		this.name = name;
		this.next = next;
	}
	
	public Artist(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist getNext() {
		return next;
	}

	public void setNext(Artist next) {
		this.next = next;
	}
	
	
}
