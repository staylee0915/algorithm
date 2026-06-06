import java.util.*;

public class zero_20260606_3 {
    public static void main(String[] args) {
        
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   int a = 0;
   int answer = sc.nextInt();
   for(int i=0;i<n-1;i++){
     a = sc.nextInt();
     if(a>answer) answer = a;
   }

   System.out.println(a);
    }
}
