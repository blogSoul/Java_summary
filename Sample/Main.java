import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] value = new int[N];
        int cnt = 0;
        for(int i = 0; i < N; i++){
            value[i] = sc.nextInt();
        }
        for(int i = N - 1; i >= 0; i--){
            cnt += K / value[i];
            K -= (K / value[i]) * value[i];
        }
        sc.close();
        System.out.print(cnt);    
    }
}
