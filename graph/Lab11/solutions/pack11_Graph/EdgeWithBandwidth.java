package solutions.pack11_Graph;

public class EdgeWithBandwidth extends Edge {
    int bandwidth;

    public EdgeWithBandwidth(int latency, int bandwidth, Node node1, Node node2) {
        super(latency, node1, node2);
        this.bandwidth = bandwidth;
    }
}
