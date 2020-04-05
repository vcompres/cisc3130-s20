package movieTitles;

public class MovieBST {
	public Movie first;
	
	public MovieBST() {
		this.first=null;
	}
	
	public void subSet(Movie node, String start, String end){
        
      /* base case */
      if (node == null) { 
          return; 
      } 
      int compareVal = start.compareToIgnoreCase(node.title);
      int endCompareVal = end.compareToIgnoreCase(node.title);
    
      /* Since the desired o/p is sorted, recurse for left subtree first 
       If root->data is greater than k1, then only we can get o/p keys 
       in left subtree */
      if (compareVal < 0) { 
          subSet(node.left, start, end); 
      } 

      /* if root's data lies in range, then prints root's data */
      if (compareVal <= 0 && endCompareVal >= 0) { 
          System.out.println(node.title + " "); 
      } 

      /* If root->data is smaller than k2, then only we can get o/p keys 
       in right subtree */
      if (endCompareVal > 0) { 
          subSet(node.right, start, end); 
      } 
		    // Selects movie titles that fall alphabetically between start and end.
	}
	
	public void add(String value, String releaseYear) {
	    this.first = addRecursive(this.first, value, releaseYear);
	}
	
	private Movie addRecursive(Movie current, String value, String releaseYear) {
	    if (current == null) {
	        return new Movie(value, releaseYear);
	    }
	    int compareVal = value.compareToIgnoreCase(current.title);
	 
	    if (compareVal < 0) {
	        current.left = addRecursive(current.left, value, releaseYear);
	    } else if (compareVal > 0) {
	        current.right = addRecursive(current.right, value, releaseYear);
	    } else {
	        return current;
	    }
	 
	    return current;
	}
	
	public void traverseInOrder(Movie node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.println(" " + node.title);
	        traverseInOrder(node.right);
	    }
	}
}
