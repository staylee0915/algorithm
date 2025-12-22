import java.util.*;

public class boj_2178 {
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] isVisit = new int[n][m];
        
        for(int i=0;i<n;i++){
            Arrays.fill(isVisit[i],-1);
        }
        //파싱
        for(int i=0;i<n;i++){
            String str = sc.next();
            for(int j=0;j<str.length();j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        //bfs를 통한 최단거리 찾기.
        Deque<Integer> dq = new ArrayDeque<>();
        int[] dx = new int[]{1,0,0,-1};
        int[] dy = new int[]{0,1,-1,0};


        //dq를 두번 사용하는 대신 pair 클래스를 정의하여 사용 하는 것이 일반적.
        dq.offerLast(0);
        dq.offerLast(0);
        isVisit[0][0]=1;

        //최종 거리
        while(!dq.isEmpty()){
            int curx = dq.pollFirst();
            int cury = dq.pollFirst();

            //목적지 도달시 종료
            if(curx == n-1 && cury == m-1){
                System.out.println(isVisit[n-1][m-1]);
                sc.close();
                return;
            }
            //상하좌우 확인하면서 갈 수 잇는 길 확인.
            for(int i=0;i<4;i++){
                
                //array의 범위를 넘어가면 pass
                int nextx = curx+dx[i];
                int nexty = cury+dy[i];

                if(nextx >=n || nextx<0 || nexty >=m || nexty<0) continue;
                //해당 구간이 지나갈 수 없는 구역이면 pass
                if(arr[nextx][nexty] == 0) continue;

                // 이미 방문한 점이면 pass
                if(isVisit[nextx][nexty]!=-1) continue;

                isVisit[nextx][nexty] = isVisit[curx][cury]+1;
                dq.offerLast(nextx);
                dq.offerLast(nexty);
            }
        }        
    }
}
