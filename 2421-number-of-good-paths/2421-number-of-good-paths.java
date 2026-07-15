import java.util.*;

class Solution {

    int[] parent;
    int[] rank;

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]); // Path Compression
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return;
        }

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {

        int n = vals.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Adjacency List
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        // value -> nodes
        TreeMap<Integer, List<Integer>> valueToNodes = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            valueToNodes.computeIfAbsent(vals[i], k -> new ArrayList<>()).add(i);
        }

        int result = n; // Every node itself is a good path

        boolean[] active = new boolean[n];

        for (Map.Entry<Integer, List<Integer>> entry : valueToNodes.entrySet()) {

            List<Integer> nodes = entry.getValue();

            // Activate nodes with current value
            for (int u : nodes) {

                for (int v : adj[u]) {

                    if (active[v]) {
                        union(u, v);
                    }
                }

                active[u] = true;
            }

            // Collect parents
            List<Integer> parents = new ArrayList<>();

            for (int u : nodes) {
                parents.add(find(u));
            }

            Collections.sort(parents);

            int size = parents.size();

            for (int j = 0; j < size; j++) {

                long count = 0;
                int currentParent = parents.get(j);

                while (j < size && parents.get(j) == currentParent) {
                    count++;
                    j++;
                }

                j--;

                result += (count * (count - 1)) / 2;
            }
        }

        return result;
    }
}