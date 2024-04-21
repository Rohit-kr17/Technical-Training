import java.util.*;

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int weight;
    
    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class BCS6649_Exp_Five {
    static int[] parent;
    
    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }
    
    static int kruskals(int g_nodes, int[] g_from, int[] g_to, int[] g_weight) {
        int totalWeight = 0;
        int edgeCount = g_from.length;
        
        // Initialize parent array for union-find
        parent = new int[g_nodes + 1];
        for (int i = 1; i <= g_nodes; i++) {
            parent[i] = i;
        }
        
        // Create list of edges
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < edgeCount; i++) {
            edges.add(new Edge(g_from[i], g_to[i], g_weight[i]));
        }
        Collections.sort(edges);
        
        // Apply Kruskal's algorithm
        for (Edge edge : edges) {
            int from = edge.from;
            int to = edge.to;
            int weight = edge.weight;
            
            if (find(from) != find(to)) {
                union(from, to);
                totalWeight += weight;
            }
        }
        
        return totalWeight;
    }
    
    public static void main(String[] args) {
        int g_nodes = 3;
        int[] g_from = {1, 2, 3};
        int[] g_to = {2, 3, 1};
        int[] g_weight = {2, 3, 5};
        
        int result = kruskals(g_nodes, g_from, g_to, g_weight);
        System.out.println("Total weight of the Really Special SubTree: " + result);
    }
}
