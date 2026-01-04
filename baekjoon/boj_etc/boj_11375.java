import java.util.*;

public class boj_11375 {
    //isVisit과 slt는 job(일)을 기준으로 함.
    public static boolean[] isVisit; //매칭되는 일을 기준으로 누가 방문하고 있는지를 판단
    public static int[] slt; // 각 일을 어떤 직원이 점유하고 있는지 판단 (직원이 점유하고 있는 정점)
    public static List<List<Integer>> vtx;

    public static boolean dfs(int v){

        //직원이 처리 가능한 일의 종류를 순회
        for(int job : vtx.get(v)){
            //해당 일을 이미 처리했다면 pass
            if(isVisit[job]) continue;
            isVisit[job]=true;
            //v번째 직원은 자신이 처리가능 한 일 중 node와 매칭됨.
            if(slt[job]==0||dfs(slt[job])){//핵심구문
                //v번쨰 직원이 점유한 노드가 없거나, dfs 탐색결과 v번쨰 직원이 점유중인 일을 점유중인 직원이 
                // 또다른 일을 점유가능한지 확인.
                slt[job] = v;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //직원수n, 일의 수 m
        //i번째 직원이 할 수 있는 일의 갯수와 일의 번호
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        isVisit = new boolean[m+1];
        slt = new int[m+1];
        vtx = new ArrayList<>();

        for(int i=0;i<=n;i++){vtx.add(new ArrayList<>());}
        
        for(int i=1;i<=n;i++){
            int k = sc.nextInt();
            for(int j=0;j<k;j++){
                //각 직원이 할 수 있는 일을 adj 형태로 초기화.
                //
                vtx.get(i).add(sc.nextInt());
            }
        }
        
        int cnt = 0;
        for(int i=1;i<=n;i++){
            //매 직원이 순회할때마다 isVisit 배열을 초기화 해야함.
            Arrays.fill(isVisit,false);

            //그래프 탐색의 결과가 true인 경우 cnt증가.
            if(dfs(i)) cnt++;
        }
        System.out.println(cnt);
        return;
    }
}
