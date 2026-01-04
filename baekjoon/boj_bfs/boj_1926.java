import java.util.*;

public class boj_1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] isVisit = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};
        int answer = 0;
        int cnt2 = 0;
        //bfs 탐색 시작
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //이미 방문했거나, 갈수 없는 곳일 경우 패스
                if(isVisit[i][j] == 1 || arr[i][j] == 0) continue;
                Deque<int[]>dq = new ArrayDeque();

                isVisit[i][j] = 1;
                dq.offer(new int[]{i,j});
                cnt2++;
                int cnt = 0;
                while(!dq.isEmpty()){
                    int[] cur = dq.pollFirst();
                    cnt++;

                    int row = cur[0];
                    int col = cur[1];

                    for(int k=0;k<4;k++){
                        int curx = row+dx[k];
                        int cury = col+dy[k];

                        //범위를 넘어가면 패스
                        if(cury<0 || cury >=m || curx<0 || curx>=n) continue;

                        //보드에 없으면 패스
                        if(arr[curx][cury]==0) continue;

                        //이미 방문한 점이면 패스
                        if(isVisit[curx][cury] == 1) continue;

                        isVisit[curx][cury]=1;
                        dq.offerLast(new int[]{curx,cury});
                    }
                }
                if(answer<cnt) answer = cnt;

            }
        }

        //그림의 갯수
        System.out.println(cnt2);
        //가장 넒은 그림의 넓이
        System.out.println(answer);

    }
}
