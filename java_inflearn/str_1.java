import java.util.*;

public class str_1{
    public static void main(String[] args) {
        // 문자열 내의 특정 문자의 갯수 구하기

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char target = sc.next().charAt(0);
        int answer = 0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            //타겟 분자에 해당하는 대문자와 소문자를 모두 세야함.
            //따라서 이경우 애초에 모두 대문자로 바꿔서 진행하면 한번에 진행 가능
            c = Character.toUpperCase(c);
            target = Character.toUpperCase(target);
            if(target == c) answer++;
        }
        System.out.println(answer);

    }
}