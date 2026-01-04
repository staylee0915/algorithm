import java.util.*;

public class boj_13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dist = new long[n];
        long[] price = new long[n];
        dist[0] = 0;
        for(int i=1;i<n;i++){
            dist[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            price[i] = sc.nextInt();
        }

        long answer = 0;
        int cur = 0;
        while(cur<n){
            if(cur+1==n) break;
            //다음 마을의 기름가격이 현재 마을보다 비싸다면, 현재마을에서 기름 주유.
            if(price[cur+1]>price[cur]){
                price[cur+1] = price[cur];
            }
            cur++;
        }
        for(int i=1;i<n;i++){
            answer += dist[i]*price[i-1];
        }
        System.out.print(answer);

    }
}
