import java.util.*;

public class boj_18352 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 도시의 갯수
        int m = sc.nextInt(); // 도로갯수
        int k = sc.nextInt(); // 거리정보 (target)
        int x = sc.nextInt(); // 출발도시 번호

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) arr.add(new ArrayList<>());

        boolean[] isVisit = new boolean[n+1];
        for(int i=0;i<m;i++){
            int idx = sc.nextInt();
            int val = sc.nextInt();
            arr.get(idx).add(val);
        }

        Deque<Integer>dq = new ArrayDeque<Integer>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);

        dq.offerLast(x);
        dist[x] = 0;

        while(!dq.isEmpty()){
            int cur = dq.pollFirst();
            //이미 거리가 k라면 확장 필요없음.
            if(dist[cur] == k) continue;
            //시작점으로 부터 순회
            for(int i=0;i<arr.get(cur).size();i++){
                // 이미 방문한 점이면 패스
                if(dist[arr.get(cur).get(i)]!=-1) continue;
                //노드에 대한 거리 갱신
                dist[arr.get(cur).get(i)] = dist[cur] +1;

                dq.offerLast(arr.get(cur).get(i));
            }
        }

        boolean flag = false;
        for(int i=1;i<=n;i++){
            if(dist[i]!=k) continue;
            System.out.println(i);
            flag = true;
        }
        if(flag==false){
            System.out.println(-1);
        }
    }
}
