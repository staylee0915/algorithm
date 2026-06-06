import java.util.*;

//배열이 가장 엄격히 증가하는 부분 배열의 길이.
public class zero_20260606_2 {
    public static void main(String[] args) {
        // 엄격히 증가한다는 것은, 중간에 감소하는 것이 없다는 것을 의미

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] chk = new int[n];
        // 배열 채우기
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int answer = 1;
        chk[0] = 1;
        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i]){
                chk[i] = chk[i-1]+1;
            }
            else{
                chk[i]=1;
            }

            // 전체의 최대값을 갱신
            if(answer < chk[i]) {
                answer = chk[i];
            }
        }
        System.out.println(answer);
    }
}
