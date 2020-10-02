```java
import java.util.Scanner;

public class Main {
    public static int dfs(Boolean[][] arr, int num){
        int i, size = arr.length, cnt = 0;
        if(size == num){
            return 1;
        }
        for(i = 0; i < size; i++){
            if(isValid(arr, num, i)) {
                arr[i][num] = true;
                cnt += dfs(arr, num+1);
                arr[i][num] = false;
            }
        }
        return cnt;
    }
    public static boolean isValid(Boolean[][] arr, int x, int y) {
        int i, diff = 0;
        for(i = x-1; i >=0; i--){
            diff++;
            if(arr[y][i] || (y - diff >= 0 && arr[y - diff][i]) || (y + diff < arr.length && arr[y + diff][i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, i, j;
        N = sc.nextInt();
        sc.close();
        Boolean[][] arr = new Boolean[N][N];
        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++){
                arr[i][j] = false;
            }
        }
        System.out.println(dfs(arr, 0));
    }
}
```