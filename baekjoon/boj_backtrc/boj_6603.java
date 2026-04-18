import java.util.*;

public class boj_6603 {

    public static int[] arr;
    public static boolean[] isVisit;
    public static int[] result;
    public static int n;

    public static void back(int next, int cnt){
        //끝까지 순회했다면 반환
        if(cnt == 6){
            for(int a : result){
                System.out.print(a+" ");
            }
            System.out.println("");
            return;
        }
        for(int i=next; i<n;i++){
            //만약 i가 방문한 숫자면, 다음 숫자로 이동하게 됨.
            //i = 0과 관련된 오름차순 모두 처리하고
            //i = 1과 관련된 오름차순 모두 처리하는 방식으로 진행됨.
            //결론적으로 전체 숫자에 대해서 오름차순으로 백트래킹을 진행하게 됨.
            if(!isVisit[i]){
                //isVisit는 static (전역)변수로 이전에 함수가 방문했다면,
                //방문 할 것으로 인식됨. 백트래킹 핵심.
                isVisit[i] = true;
                result[cnt]=arr[i];
                //다음 깊이로 이동, 그리고 다음숫자 탐색
                back(i+1,cnt+1);

                //백트래킹
                //가장 마지막에 방문한 숫자 바로 이전수를 방문하지 않을 것으로 함.
                //그리고 다음 수를 늘림
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        //49가지 수 중 k 개 선택 (k>6)하여 집합 s 구성 후
        //그 중 6개를 골라 집합 생성
        Scanner sc = new Scanner(System.in);

        while(true){
            n = sc.nextInt();
            if(n==0) break;
            arr = new int[n];
            result = new int[6];
            isVisit = new boolean[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            back(0,0);
            System.out.print("\n");

        }
    }
}
