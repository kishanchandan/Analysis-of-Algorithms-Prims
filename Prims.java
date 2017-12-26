package primsalgo;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Prims {
  public static void main (String[] args) {
 
    int edgecount=0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of vertices: ");
    edgecount = sc.nextInt();
    int[][] graph = new int[edgecount+2][edgecount+2];
    for(int i=0;i<edgecount;i++) {
    	for(int j=0;j<edgecount;j++) {
    		graph[i][j] = sc.nextInt();
    	}
    	
    }
     
    	int n = graph.length;
        Edges[] output = new Edges[n-1];

        PriorityQueue<Vertex> prioriQue = new PriorityQueue<Vertex>(n, new ComparePriority());
        for (int i = 1; i < n; i++) {
          prioriQue.add(new Vertex(i, 999));
          output[i-1] = new Edges(i, -1);
        }
        prioriQue.add(new Vertex(0, 0));

        while (!prioriQue.isEmpty()) {
          int u = prioriQue.remove().key;
          
          for (int v = 0; v < n; v++) {
            int weight = graph[u][v];
            if (weight > 0) {
              for (Vertex pv : prioriQue) {
                if ((pv.key == v) && (weight < pv.weight)) {
                  output[v-1].end = u;
                  prioriQue.remove(pv);
                  pv.weight = weight;
                  prioriQue.add(pv);
                  break;
                }
              }
            }
          }
        }
    
    for (Edges e : output) {
      System.out.println(e + " with weight of " + graph[e.start][e.end] );
    }
  }
  
}