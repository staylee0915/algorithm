import java.util.*;

public class zero_20260606_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        //자바 정수형이 가질 수 있는 '최솟값'으로 초기화
        int answer = Integer.MIN_VALUE; 

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            
            if(a > answer) {
                answer = a;
            }
        }

        System.out.println(answer);
    }
}