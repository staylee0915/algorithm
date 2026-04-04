import java.util.*;

public class boj_7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int col = sc.nextInt();
        int row = sc.nextInt();
        int[][] arr = new int[row][col];
        int[][] isVisit = new int[row][col];
        int[] dx = {0,1,-1,0};
        int[] dy = {-1,0,0,1};
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        //토마토가 2개 이상이라고 하면
        //각 토마토가 익는 지점이 토마토 시작시점에 따라 min 값으로 처리되어야 한다.
        Deque<int[]> dq = new ArrayDeque<>();

                for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == -1) {
                    isVisit[i][j] = -1;
                } else if (arr[i][j] == 0) {
                    isVisit[i][j] = 0;
                } else if (arr[i][j] == 1) {
                    //모든 토마토 시작점을 큐에 넣는다.
                    isVisit[i][j] = 1;
                    dq.offerLast(new int[] {i,j});
                }
            }
        }


        //bfs 시작
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int r = cur[0];
            int c = cur[1];
            for(int k=0;k<4;k++){
                int curr = r+dx[k];
                int curc = c+dy[k];
                //범위 밖일 경우 pass
                if(curr < 0 || curc <0 || curr>=row || curc>=col) continue;
                //방문지점이 현재의 노드에서의 방문보다 작을경우 패스
                if(isVisit[curr][curc]!=0) continue;

                isVisit[curr][curc] = isVisit[r][c]+1;
                dq.offerLast(new int[] {curr,curc});
            }
        }


        //isVisit에서 가장 큰 수를 찾아 출력한다.
        int answer = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                // 아직 익지 않은 토마토가 남아있으면 실패
                if (arr[i][j] == 0 && isVisit[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, isVisit[i][j]);
            }
        }
        //시작점을 1로 잡았음으로 1을 뺀다.
        System.out.println(answer-1);
    }
}
