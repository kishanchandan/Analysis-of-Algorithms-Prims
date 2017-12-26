package primsalgo;
import java.util.Comparator;

public class ComparePriority implements Comparator<Vertex>{
	 public int compare(Vertex first, Vertex second) {
		    return first.weight - second.weight;
		  }
}
