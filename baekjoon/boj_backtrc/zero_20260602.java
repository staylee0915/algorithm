import java.util.*;

public class zero_20260602 {

  public static int n;
 public static void dfs(String s, int open, int close, int n){

  if(n+2 == s.length()) {System.out.println(s); return ;}
   //open이 n보다 작으면 항상 추가 가능 (단 n보다는 작아야함, 최대 n개 까지 "(" 가능
  if (open < n) {dfs(s+"(",open + 1, close, n);}
  
  // open + 1이 끝난 다음은 open 파라메터로 다음 상태로 이동함으로, 백트래킹 되었다고 볼 수 있다.

   //close는 open 보다 작아야만 추가 가능 (짝이 맞아야 함으로)
  if (close < open) {dfs(s+")",open, close+1, n);}
   return;
 }
 public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   n = sc.nextInt();
   //stack을 활용 - backtracking
   dfs("",0,0,n);
 }

}

