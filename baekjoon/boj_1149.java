import java.util.*;

public class boj_1149 {

    public static int n;
    public static int[][] arr;
    public static int[][] memoi;
    public static int dp(int c, int cnt){
        int minv = 0;
        //종료조건
        if(cnt == n-1){
            return arr[cnt][c];
        }
        // 이미 계산된 값이 있으면, 해당 값과 비교하여 반환.
        if(memoi[cnt][c]!=0) return memoi[cnt][c];
        else{
            if(c==0) minv = Math.min(dp(1,cnt+1),dp(2, cnt+1));
            if(c==1) minv = Math.min(dp(0,cnt+1),dp(2,cnt+1));
            if(c==2) minv = Math.min(dp(0,cnt+1),dp(1,cnt+1));
        }
        memoi[cnt][c] = arr[cnt][c] + minv;
        return memoi[cnt][c];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][3];
        memoi = new int[n][3];
        //배열의 초기화
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        //이웃한 것 끼리는 같은색을 사용할 수 없다.
        //모든집을 칠하는 비용의 최솟값.
        //시작으로 r을 선택할때, g를 선택할때, b를 선택할때로 구분.
        int first = dp(0,0);
        int second = dp(1,0);
        int third = dp(2, 0);

        //f s t중 최솟값을 반환.
        System.out.println(Math.min(first, Math.min(second,third)));

    }
}
