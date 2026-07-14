class Solution {
    class Edge{
        int dest;
        boolean path;
        public Edge(int d, boolean p){
            this.dest = d;
            this.path = p;
        }
    }
    public int count = 0;
    public void dfs(List<List<Edge>> graph, boolean[] vis, int curr){
        vis[curr] = true;
        for(Edge next : graph.get(curr)){
            if(next.path && !vis[next.dest]){
                count++;
            }
            if(!vis[next.dest]){
                dfs(graph, vis, next.dest);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            graph.get(u).add(new Edge(v, true));
            graph.get(v).add(new Edge(u, false));
        }

        boolean[] vis = new boolean[n];

        dfs(graph, vis, 0);

        return count;
    }
}