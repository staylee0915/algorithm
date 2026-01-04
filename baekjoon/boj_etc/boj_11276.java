import java.util.*;
import java.lang.Math;
public class boj_11276 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 우선순위 큐의 정렬 조건을 커스텀
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            //절대 값이 같다면 실제 값이 더 작은 것이 먼저 오도록
            if(abs1==abs2) return o1-o2;
            //절대값이 다르다면 절대값이 더 작은 값이 먼저 오도록
            return abs1-abs2;
        });

        for(int i=0;i<n;i++){

            int t = sc.nextInt();
            if(t==0){
                if(pq.isEmpty()) System.out.println(0);
                else{
                    System.out.println(pq.poll());
                }
            }else{
                pq.offer(t);
            }
        }

    }
}
