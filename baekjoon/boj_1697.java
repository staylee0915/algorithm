// ; 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 
// ; 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
// ; 수빈이는 걷거나 순간이동을 할 수 있다. 
// ; 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
// ; 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
// ; 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

import java.util.*;
public class boj_1697 {

    public static int arr[] = new int[100001];

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();//수빈
        int b = sc.nextInt();//동생

        //a위치에서 갈 수 있는 경우의 수는 3가지 -1, +1, *2 이다.
        Deque<Integer>dq = new ArrayDeque();

        dq.offer(a);
        Arrays.fill(arr,0);
        arr[a] = 0;
        
        while(!dq.isEmpty()){
            int cur = dq.poll();
            if(b == cur) {System.out.println(arr[cur]); break;}
            int[] nextPos = {cur-1,cur+1,2*cur};
            int cnt = arr[cur]+1;
            for(int i=0;i<3;i++){
                //범위를 넘어가면 pass
                if(nextPos[i] < 0 || nextPos[i]>100000) continue;

                //시작점도 아니고 한번도 방문한적 없다면
                if(arr[nextPos[i]]==0 && nextPos[i]!=a){
                    arr[nextPos[i]]= cnt;
                }else{
                    //이미 방문했고, 현재보다 더 작은 경로를 갖고 있다면 pass
                    if(arr[nextPos[i]]<cnt) continue;

                    //현재 경로가 더 적은 최소 거리를 갖고 있다면 갱신.
                    if(arr[nextPos[i]]>cnt) arr[nextPos[i]] = cnt;
                }
                dq.offerLast(nextPos[i]);
            }
        }


    }

}
