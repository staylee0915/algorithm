import java.util.*;

public class boj_14888{

    public static List<Integer>isVisit;
    public static int[] dx = new int[4]; // 연산자의 갯수 (덧셈, 뺼셈, 곱셈, 나눗셈)

    public static int dfs(int num){

        if(dx[0]==0 && dx[1]==0 && dx[2]==0 && dx[3]==0){

        }
        return 0; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<Integer>arr = new ArrayList<>();

        //전체수의 나열 순서는 동일함.
        //백트래킹으로 연산자의 조합을 골라내야

        //전체 수 입력
        for(int i=0;i<n;i++) arr.add(sc.nextInt());

        //연산자 갯수
        for(int i=0;i<4;i++) dx[i] = sc.nextInt();

        //처음을 연산자 4개 중 어디부터 시작할 것인지 결정
        for(int start=0;start<4;start++){
            int v = dfs(start);
        }


    }
}