class Solution {
    public int[] findOrder(int n, int[][] p) {
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
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            if(state[i]==0){
                if(!dfs(adj, state, i, st)) return new int[0];
            }
        }

        int[] ans = new int[n];
        int i=0;
        while(!st.isEmpty()){
            ans[i++]=st.pop();
        }

        return ans;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj , int[] state, int s, Stack<Integer> st){
        state[s]=1;

        for(int nbr: adj.get(s)){
            if(state[nbr]==0){
                if(!dfs(adj, state, nbr, st)){
                    return false;
                }
            }
            else if(state[nbr]==1){
                return false;
            }
        }
        st.push(s);
        state[s]=2;
        return true;
    }
}