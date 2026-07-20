class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return dfs(graph, 0, -1, hasApple);
    }

    public int dfs(List<List<Integer>> graph, int curr, int par, List<Boolean> hasApple){
        int time = 0;
        for(int child: graph.get(curr)){
            if(child == par) continue;
            
            // time to collect apples from child
            int ttcafc = dfs(graph, child, curr, hasApple);

                            // if current child has apple
            if(ttcafc > 0 || hasApple.get(child)){
                time += ttcafc + 2;
            }
        }
        return time;
    }
}
