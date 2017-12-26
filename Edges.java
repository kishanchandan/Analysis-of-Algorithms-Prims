package primsalgo;
public class Edges {
	int start;
	  int end;
		
	  public Edges (int s, int e) {
	    start = s;
	    end = e;
	  }
  public String toString() {
    return "Vertex from " + start + " to" + " " + end;
  }
}