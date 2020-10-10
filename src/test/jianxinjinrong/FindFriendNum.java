package test.jianxinjinrong;

public class FindFriendNum {
    public int findFriendNum(int[][] M) {
        // write code here
        boolean[] visited = new boolean[M.length];
        int friendNum = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == false) {
                dfs(M, visited, i);
                friendNum++;
            }
        }
        return friendNum;
    }

    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}
