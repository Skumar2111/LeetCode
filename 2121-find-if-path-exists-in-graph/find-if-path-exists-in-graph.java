class Solution {

    public boolean validPath(int n, int[][] edges,
                             int source, int destination) {

        List<List<Integer>> graph = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(int current,
                        int destination,
                        List<List<Integer>> graph,
                        boolean[] visited) {

        // Destination found
        if (current == destination) {
            return true;
        }

        // Mark current node
        visited[current] = true;

        for (int neighbor : graph.get(current)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, destination, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}