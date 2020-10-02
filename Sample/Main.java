import java.util.Scanner;

public class Main {
    public static int arr[][] = new int[9][9];
    public static ArrayList<int[]> list = new ArrayList<>();
    public static boolean check = false;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i, j;
        for(i = 0; i < 9; i++){
            for(j = 0; j < 9; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 0){
                    list.add(new int[] { i, j });
                }
            }
        }
        sc.close();
        backTracking(0);
    }
    public static void printArr(){
        int i, j;
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < 9; i++){
            for(j = 0; j < 9; j++){
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    } // 9x9 array print!
    public static void backTracking(int index){
        // list index를 확인하는 int index 함수
        int x, y, i;
        if(check)
            return;
        if(index >= list.size()){
            printArr();
            check = true;
            return;
        }
        x = list.get(index)[0];
        y = list.get(index)[1];
        for(i = 1; i < 10; i++){
            if(findX(x, y, i)) {
                arr[x][y] = i;
                backTracking(index + 1);
                arr[x][y] = 0;
            }
        }
    }
    public static boolean findX(int x, int y, int num){
        int i, j;
        for(i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++){
            for(j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++){
                if(arr[i][j] == num)
                    return false;
            }
        }
        for(i = 0; i < 9; i++){
            if(arr[x][i] == num)
                return false;
            if(arr[i][y] == num)
                return false;
        }
        return true;
    } // 스도쿠에 들어가는 숫자가 맞는지 확인
}
