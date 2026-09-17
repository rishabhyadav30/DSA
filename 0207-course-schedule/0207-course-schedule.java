class Solution {
    public boolean canFinish(int n, int[][] p) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<p.length; i++){
            int u= p[i][1];
            int v= p[i][0];
            adj.get(u).add(v);
        }

        int[] state =new int[n];

        for(int i=0; i<n; i++){
            if(state[i]==0){
                if(!dfs(adj, state, i)) return false;
            }
        }

        return true;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj , int[] state, int s){
        state[s]=1;

        for(int nbr: adj.get(s)){
            if(state[nbr]==0){
                if(!dfs(adj, state, nbr)){
                    return false;
                }
            }
            else if(state[nbr]==1){
                return false;
            }
        }
        state[s]=2;
        return true;
    }
}