package movieTitles;

public class Movie {
	
	  public String title;
	  public String releaseYear;
	  public String[] genres; // optional
	  public int movieId; //optional
	  
	  public Movie left;
	  public Movie right;
	  
		public Movie(String title) {
			super();
			this.title = title;
			this.left = null;
			this.right = null;
		}
		
		public Movie(String title, String releaseYear) {
			super();
			this.title = title;
			this.releaseYear = releaseYear;
			this.left = null;
			this.right = null;
		}
  
  
}
