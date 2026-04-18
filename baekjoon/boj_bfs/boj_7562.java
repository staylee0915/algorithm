import java.util.*;
public class boj_7562 {

    public static class Node{
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt){
            this.x =x;
            this.y =y;
            this.cnt = cnt;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dx[] = {-2,-2,2,2,-1,1,-1,1};
        int dy[] = {1,-1,1,-1,2,2,-2,-2};
        int tx,ty;
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int size = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            tx = sc.nextInt();
            ty = sc.nextInt();
            Node node = new Node(x, y, 0);

            //각 tc 마다 bfs 수행
            Deque<Node>dq = new ArrayDeque<>();
            int[][] isVisit = new int[size][size];
            dq.offerLast(node);
            isVisit[node.x][node.y] = 1;
            //큐가 비어있지 않았다면 계속 진행
            while(!dq.isEmpty()){
                Node cur = dq.poll();
                if(cur.x == tx && cur.y == ty){
                    System.out.println(cur.cnt);
                    break;
                }
                for(int k=0;k<8;k++){
                    int curx = cur.x+dx[k];
                    int cury = cur.y+dy[k];
                    if(curx<0||cury<0||curx>=size||cury>=size) continue;
                    if(isVisit[curx][cury]==1) continue;
                    dq.offerLast(new Node(curx,cury,cur.cnt+1));
                    isVisit[curx][cury]=1;
                }

            }
        }
    }
}
