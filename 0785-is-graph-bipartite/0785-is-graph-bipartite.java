class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        
        for(int i=0; i<n; i++){
            if(color[i]==-1){
                if(!dfs(graph,color,i,0)) return false;
            }
        }
        
        return true;
    }

    public boolean dfs(int[][] graph, int[] color, int s, int col){

        color[s]=col;

        for(int nbr: graph[s]){
            if(color[nbr]==-1){
                if(!dfs(graph,color,nbr,1-col)){
                    return false;
                }
            }
            else if(color[nbr]==col){
                return false;
            }
        }

        return true;
    }
}