class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        int[] state = new int[V];
        
        for(int i=0; i<V; i++){
            if(state[i]==0){
                if(dfs(adj,state,i)) return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] state, int s){
        
        state[s]=1;
        
        for(int nbr: adj.get(s)){
            if(state[nbr]==0){
                if(dfs(adj,state,nbr)) return true;
            }
            
            else if(state[nbr]==1){
                return true;
            }
        }
        state[s]=2;
        return false;
    }
}