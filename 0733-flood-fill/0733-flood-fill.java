class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int org = image[sr][sc];
        if(image[sr][sc]==color) return image;
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sr,sc});

        image[sr][sc]=color;

        int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            for(int[] d: dir){
                int nr = cr+ d[0];
                int nc = cc+ d[1];

                if(nr>=0 && nc>=0 && nr<image.length && nc<image[0].length && image[nr][nc]==org){
                    image[nr][nc]=color;
                    q.offer(new int[]{nr,nc});
                }
            }

        }
        return image;
    }
}