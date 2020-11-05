import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main{
    public static ArrayList<Integer> arr;
    public static int Max(ArrayList<Integer> arr){
        int max = 0, index = -1, size = arr.size();
        for(int i = 0; i < size; i++){
            max = (max < arr.get(i)) ? arr.get(i) : max;
            index = (max == arr.get(i)) ? i : index;
        }
        if(index != -1)
            arr.remove(index);
        return max;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                sb.append(Max(arr) + "\n");
            } else {
                arr.add(num);
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}