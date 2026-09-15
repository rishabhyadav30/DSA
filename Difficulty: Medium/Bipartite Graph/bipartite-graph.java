class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int n = edges.length;
        for(int i=0;  i<n ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
        
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] color = new int[V];
        Arrays.fill(color,-1);
        
        for(int i=0; i<V; i++){
            if(color[i]==-1){
                if(!dfs(adj,color,i,0)) return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] color, int s, int col){
        
        color[s]=col;
        
        for(int nbr: adj.get(s)){
            if(color[nbr]==-1){
                if(!dfs(adj,color,nbr,1-col)) return false;
            }
            else if(color[nbr] == col) return false;
        }
        
        return true;
    }
}