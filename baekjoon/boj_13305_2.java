import java.util.*;

public class boj_13305_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] dist = new long[n];
        long[] price = new long[n];
        long answer = 0;

        dist[0] = 0;
        // 각 장소까지의 거리
        for(int i = 1; i<n;i++){
            dist[i] = sc.nextInt();
        }
        // 각 마을의 기름 가격
        for(int i=0;i<n;i++){
            price[i] = sc.nextInt();
        }

        long p = price[0];
        for(int i=1;i<n;i++){
            //기름값의 최솟값을 계속 갱신하면서, dist와 곱한 값을 더해주면 됨.
            answer+= p*dist[i];
            p = Math.min(p,price[i]);
        }
        System.out.println(answer);
    }
}
