import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static int check(ArrayList<Integer> arr, int num){
        int start = 0, end = arr.size() - 1, mid;
        while(end > start){
           mid = (start + end) / 2;
           if(arr.get(mid) >= num){
               end = mid;
           } else {
               start = mid + 1;
           }
        }
        return end;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(list.get(list.size() - 1) < arr[i]){
                list.add(arr[i]);
            } else {
                list.set(check(list, arr[i]), arr[i]);
            }
        }
        bw.write(Integer.toString(list.size() - 1));
        br.close();
        bw.close();
    }
}