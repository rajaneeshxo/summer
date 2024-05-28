package io.rjnsh.summer.cp.sort;

import java.util.Arrays;

public class EdgeByWeight {
    public static void main(String[] args) {
        Edge[] edges = {new Edge(0, 1, 3), new Edge(0,9,10)};

        Arrays.sort(edges, (Edge x, Edge y) -> Integer.compare(x.weight, y.weight));
        System.out.println("edges " + Arrays.deepToString(edges));
    }
}

class Edge {
    int src;
    int dest;
    int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {

        return String.format(" { %d } ", this.weight);
    }
}