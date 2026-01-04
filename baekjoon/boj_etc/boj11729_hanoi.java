import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.Math;
//세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 
//각 원판은 반경이 큰 순서대로 쌓여있다. 
//이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.

//한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
//쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
//이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.

public class boj11729_hanoi {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기

    public static void hanoi(int n, int start, int to, int via) throws IOException{
        //크기순서 3<2<1 (1에 가까운 원판이 더 큰 원판. 큰 원판은 작은 원판 위에 잇을 수 없음.)
        if(n==1){
            bw.write(start+" "+to+"\n");
        }else{
            //n-1개의 원판을 start에서 via로 이동
            hanoi(n-1,start,via,to);
            //가장 큰 원판을 to로 이동
            bw.write(start+" "+to+"\n");
            //via의 n-1개의 원판을 to로 이동
            hanoi(n-1,via,to,start);
            //System.out.println()
        }        
    }
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(bf.readLine()); //Int

        //원판의 갯수
        bw.write((int)Math.pow(2,n)-1+"\n");

        hanoi(n,1,3,2);
        bw.flush();
        bw.close();
        bf.close();
    }
}
