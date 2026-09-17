class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
             int u = edges[i][0];
             int v = edges[i][1];
            
            adj.get(u).add(v);
        }
        
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
    
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(adj,vis,i,st);
            }
        }
        
        ArrayList<Integer>  ans =new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        
        return ans;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int s, Stack<Integer> st){
        
        vis[s]=true;
        
        for(int nbr: adj.get(s)){
            if(!vis[nbr]){
                dfs(adj,vis,nbr,st);
            }
        }
        st.push(s);
    }
}