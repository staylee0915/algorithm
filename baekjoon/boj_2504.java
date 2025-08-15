import java.util.*;
public class boj_2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Deque<Character>dq = new ArrayDeque<>();
        int answer = 0;
        int tmp = 1;

        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(c == '('||c == '['){
                //tmp에 *연산을 적용하는 것이 핵심.
                dq.offerLast(c);
                if(c=='(') tmp*=2;
                if(c=='[') tmp*=3;
            }

            if(c==')'){
                //직전괄호가 열린괄호면 answer+=tmp
                if(dq.isEmpty() || dq.peekLast() != '('){
                    System.out.print(0); return;
                }
                //직전괄호가 열린괄호 일때만 더한다. (-> 이전 )->현재
                if(s.charAt(i-1)=='(') answer+=tmp;
                tmp/=2;
                dq.pollLast();
                continue;
            }
            if(c==']'){
                if(dq.isEmpty() || dq.peekLast() != '['){
                    System.out.print(0); return;
                }
                //직전괄호가 열린괄호 일때만 더한다.
                if(s.charAt(i-1)=='[') answer+=tmp;
                tmp/=3;
                dq.pollLast();
                continue;
            }
        }
        if(!dq.isEmpty()){System.out.print(0); return;}
        System.out.print(answer);
    }
}
