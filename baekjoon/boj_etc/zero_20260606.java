import java.util.*;

public class zero_20260606 {
    public static void main(String[] args) {
        //연속된 부분배열의 최대합
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] chk = new int[n];

        Arrays.fill(chk,0);
        // 배열 채우기
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        chk[0] = arr[0];
        answer = chk[0];
        for(int i=1;i<n;i++){
            chk[i] = Math.max(chk[i-1]+arr[i],arr[i]);
            if(answer<chk[i]) answer = chk[i];
        }
        System.out.println(answer);
    }
}
