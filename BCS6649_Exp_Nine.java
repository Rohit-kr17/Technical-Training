import java.util.*;

public class BCS6649_Exp_Nine {
    
    // Function to calculate the total distance of a tour
    static int calculateTotalDistance(int[][] graph, List<Integer> tour) {
        int totalDistance = 0;
        int n = tour.size();
        
        for (int i = 0; i < n - 1; i++) {
            int u = tour.get(i);
            int v = tour.get(i + 1);
            totalDistance += graph[u][v];
        }
        
        // Add distance from last city back to the starting city
        totalDistance += graph[tour.get(n - 1)][tour.get(0)];
        
        return totalDistance;
    }
    
    // Function to generate all possible permutations of cities
    static List<List<Integer>> generatePermutations(int n) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> cities = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            cities.add(i);
        }
        
        generatePermutationsHelper(cities, n, permutations);
        
        return permutations;
    }
    
    // Helper function to generate permutations using backtracking
    static void generatePermutationsHelper(List<Integer> cities, int n, List<List<Integer>> permutations) {
        if (cities.size() == 1) {
            permutations.add(new ArrayList<>(cities));
            return;
        }
        
        for (int i = 0; i < cities.size(); i++) {
            int currentCity = cities.get(i);
            List<Integer> remainingCities = new ArrayList<>(cities);
            remainingCities.remove(i);
            generatePermutationsHelper(remainingCities, n, permutations);
            remainingCities.add(i, currentCity);
        }
    }
    
    // Function to find the shortest tour using brute force
    static List<Integer> findShortestTour(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> permutations = generatePermutations(n);
        List<Integer> shortestTour = new ArrayList<>();
        int shortestDistance = Integer.MAX_VALUE;
        
        for (List<Integer> permutation : permutations) {
            int distance = calculateTotalDistance(graph, permutation);
            if (distance < shortestDistance) {
                shortestDistance = distance;
                shortestTour = permutation;
            }
        }
        
        return shortestTour;
    }
    
    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        
        List<Integer> shortestTour = findShortestTour(graph);
        
        System.out.println("Shortest tour: " + shortestTour);
    }
}
