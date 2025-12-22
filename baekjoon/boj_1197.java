import java.util.*;

public class boj_1197 {

    public static int[] parent; // parent를 저장하기 위함.

    public static int find(int x){
        if(parent[x] < 0) return x; //parent가 음수이면 rank를 의미함으로 자기자신이 부모(루트)노드
        return parent[x] = find(parent[x]);
    } 
    public static boolean Union(int n1, int n2){
        //두 정점의 부모를 비교
        int fn1 = find(n1);
        int fn2 = find(n2);

        //두 정점이 같은 군집에 속해 있으면 false를 반환 (같은부모)
        if(fn1==fn2) return false;

        //두 정점의 높이를 비교
        //fn1과 fn2는 n1와 n2의 부모노드를 가리킴으로
        //fn1과 fn2의 parent배열에서의 값은 rank를 의미한다.
        //fn2가 항상 더 작은 쪽을 만들어 주기 위해서 swap 한다.
        if(parent[fn1]<parent[fn2]){
            int temp = fn1;
            fn1 = fn2;
            fn2 = temp;
        }
        //fn1과 fn2의 rank가 같다면, fn2의 높이를 하나 높인다. (fn2쪽으로 두 노드를 합치기 위함)
        if(parent[fn1] == parent[fn2]) parent[fn2]--;

        //fn1의 군짐(부모)를 fn2로 만든다
        parent[fn1] = fn2;

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        parent = new int[v+1];
        //각 노드가 -1임은 모두 자기 자신이 부모임을 의미
        Arrays.fill(parent,-1);
        
        // 정점과 가중치를 저장하기 위한 이차원 배열
        int[][] arr = new int[e][3];
        for(int i=0;i<e;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        //오름차순 정렬
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] n1, int[]n2){
                return n1[2]-n2[2];
            }
        });
        //람다식 변환 예시.
        //Arrays.sort(arr, (n1, n2) -> Integer.compare(n1[2], n2[2]));

        //각 오름차순된 간선들을 순회하면서, 최소신장트리의 가중치를 찾는다.
        int answer = 0;
        for(int i=0;i<e;i++){
            int v1 = arr[i][0];
            int v2 = arr[i][1];
            int w = arr[i][2];
            if(Union(v1,v2)) answer += w;
        }
        System.out.println(answer);
    }
    
}
