class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // Nodes are 1 to n
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        // Build directed weighted graph
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            adj.get(u).add(new Pair(v, weight));
        }

        PriorityQueue<Pair> priorityQueue =
                new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        int[] distance = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[k] = 0;

        priorityQueue.add(new Pair(k, 0));

        // Dijkstra
        while (!priorityQueue.isEmpty()) {

            Pair current = priorityQueue.poll();

            int node = current.node;
            int dist = current.weight;

            // Ignore stale entries
            if (dist > distance[node]) {
                continue;
            }

            for (Pair edge : adj.get(node)) {

                int adjNode = edge.node;
                int edgeWeight = edge.weight;

                int newDistance = dist + edgeWeight;

                if (newDistance < distance[adjNode]) {

                    distance[adjNode] = newDistance;

                    priorityQueue.add(
                            new Pair(adjNode, newDistance)
                    );
                }
            }
        }

        // Find maximum shortest distance
        int max = 0;

        for (int i = 1; i <= n; i++) {

            // Some node cannot be reached
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, distance[i]);
        }

        return max;
    }
}

class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}