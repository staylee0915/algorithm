import java.util.*;

public class zero_20260606_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // 💡 중요: answer를 0이 아닌, 자바 정수형이 가질 수 있는 '최솟값'으로 초기화합니다.
        // 이렇게 하면 첫 번째 숫자가 음수(-9999)여도 무조건 첫 숫자로 answer가 정상 갱신됩니다.
        int answer = Integer.MIN_VALUE; 
        
        // 정확하게 N번만큼만 깔끔하게 돌면서 데이터를 읽어옵니다.
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            
            if(a > answer) {
                answer = a;
            }
        }

        System.out.println(answer);
    }
}