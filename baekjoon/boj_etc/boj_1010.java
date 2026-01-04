import java.util.*;
public class boj_1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();

        // 2. T번 반복하며 각 테스트 케이스를 처리합니다.
        for(int i = 0; i < t; i++) {
 
            long result = 1;

            int m = sc.nextInt(); //선택개수
            int n = sc.nextInt(); //전체

            // 분모역햘 1
            int r = 1; 

            // 분자는 m부터 n-m+1 까지의 곱
            // 분모는 1부터 m까지의 순회곱
            // nCm = (n-m)! / m!
            for(int j = n; j > n - m; j--) {
                result *= j;
                result /= r;
                
                // 분모 r을 증가시킵니다.
                r++;
            }
            
            // 4. 계산된 최종 조합의 수를 출력합니다.
            System.out.println(result);
        }
    }
}
