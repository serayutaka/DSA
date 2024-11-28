package solutions.pack11_Graph;

import java.util.*;

public class NetworkOptimizer {

    public int optimizeNetwork(int N, int M, int[][] input) {

        int totalLatency = 0;

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < input.length; i++) {
            int node1Id = input[i][0];
            int node2Id = input[i][1];
            int latency = input[i][2];
            Edge edge = new Edge(latency, nodes[node1Id - 1], nodes[node2Id - 1]);
            nodes[node1Id - 1].addEdge(edge);
            nodes[node2Id - 1].addEdge(edge);
        }

        /*
         * TASK 2: Implement PRIM's algorithm to find the minimum spanning tree
         * by using latency as the weight
         * 
         * The algorithm should return the total latency of the minimum spanning tree
         */

        Node startNode = nodes[0];
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());

        // implement the algorithm here
        pq.addAll(startNode.getEdges());
        Set<Integer> visited = new HashSet<>();
        visited.add(startNode.getId());
        int edgeCount = 0;
        while (!pq.isEmpty() && edgeCount < N - 1) {
            Edge edge = pq.poll();
            Node node1 = edge.node1;
            Node node2 = edge.node2;

            if (!visited.contains(node1.getId()) && !visited.contains(node2.getId())) {
                continue;
            }
            Node unvisitedNode = !visited.contains(node1.getId()) ? node1 : node2;

            visited.add(unvisitedNode.getId());
            totalLatency += edge.getLatency();
            edgeCount += 1;

            for (Edge e : unvisitedNode.getEdges()) {
                if (!visited.contains(e.node1.getId()) || !visited.contains(e.node2.getId())) {
                    pq.add(e);
                }
            }
        }

        return totalLatency;
    }

    // Overload the optimizeNetwork method
    public int optimizeNetwork(int N, int M, int T, int[][] input) {
        int totalLatency = 0;

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < input.length; i++) {
            int node1Id = input[i][0];
            int node2Id = input[i][1];
            int latency = input[i][2];
            int bandwidth = input[i][3];
            EdgeWithBandwidth edge = new EdgeWithBandwidth(latency, bandwidth, nodes[node1Id - 1], nodes[node2Id - 1]);
            nodes[node1Id - 1].addEdgeWithBandwidth(edge);
            nodes[node2Id - 1].addEdgeWithBandwidth(edge);
        }

        /*
         * TASK 3: Implement PRIM's algorithm to find the minimum spanning tree
         * by using latency as the weight and
         * the edge that have bandwidth less than T should not be included in the
         * minimum spanning tree
         * 
         * The algorithm should return the total latency of the minimum spanning tree
         */
        Node startNode = nodes[0];
        PriorityQueue<EdgeWithBandwidth> pq = new PriorityQueue<>(new EdgeComparator());

        // implement the algorithm here
        for (EdgeWithBandwidth edge : startNode.getEdgesWithBandwidth()) {
            if (edge.bandwidth >= T) pq.add(edge);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(startNode.getId());
        int edgeCount = 0;

        while (!pq.isEmpty() && edgeCount < N - 1) {
            EdgeWithBandwidth edge = pq.poll();
            Node node1 = edge.node1;
            Node node2 = edge.node2;

            if (visited.contains(node1.getId()) && visited.contains(node2.getId())) continue;

            totalLatency += edge.getLatency();
            edgeCount += 1;

            Node unvisitedNode = !visited.contains(node1.getId()) ? node1 : node2;
            visited.add(unvisitedNode.getId());
            for (EdgeWithBandwidth e : unvisitedNode.getEdgesWithBandwidth()) {
                if (!visited.contains(e.node1.getId()) || !visited.contains(e.node2.getId())) {
                    if (e.bandwidth >= T) pq.add(e);
                }
            }
        }

        return edgeCount == N - 1 ? totalLatency : -1;

    }

}
