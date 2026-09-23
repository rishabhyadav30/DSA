class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int u= edges[i][0];
            int v= edges[i][1];
        
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int dis[] =new int[V];
        Arrays.fill(dis,-1);
        
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(src);
        dis[src]=0;
        
        while(!q.isEmpty()){
            int n = q.poll();
            
            for(int nbr: adj.get(n)){
                if(dis[nbr]==-1){
                    dis[nbr]=dis[n]+1;
                    q.add(nbr);
                }
            }
        }
        
        return dis[dest];
        
    }
}