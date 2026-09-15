class Solution {
    public boolean isCycle(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        int n = edges.length;
        
        for(int i=0; i<n; i++){
            int u= edges[i][0];
            int v= edges[i][1];
        
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis= new boolean[V];
        
        for(int i=0;i<V;i++) {
            if(!vis[i] && bfs(adj,vis,i))
                return true;
        }

        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int s){
        
        Queue<int[]> q = new ArrayDeque<>(); 
        vis[s]=true;
        q.add( new int[]{s,-1});
        
        while(!q.isEmpty()){
            int size= q.size();
            
            for(int i=0; i<size; i++){
                int[] curr =  q.poll();
                
                int src = curr[0];
                int parent = curr[1];
                
                for(int nbr: adj.get(src)){
                    if(!vis[nbr] ){
                         vis[nbr]=true;
                         q.add(new int[]{nbr,src})
                         ;
                    }
                    else if( nbr != parent) return true;
                }
            }
            
        }
        
        return false;
    }
}