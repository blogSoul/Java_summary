import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

class Pointer implements Comparable<Pointer>{
    private int x, y;
    public Pointer(Integer a, Integer b){
        x = a;
        y = b;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    @Override
    public int compareTo(Pointer p){
        int num = this.x - p.x;
        if(num == 0){
            num = this.y - p.y;
        }
        return num;
    }
}

class PointerY implements Comparator<Pointer>{
    @Override
    public int compare(Pointer a, Pointer b){
        return a.getY() - b.getY();
    }
}

public class Main {
    public static int distance(Pointer a, Pointer b){
        return (a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY());
    }
    public static int Findshortest(List<Pointer> list, int x, int y){
        int ans = Integer.MAX_VALUE;
        for(int i = x; i <= y; i++){
            for(int j = i + 1; j <= y; j++){
                int num = distance(list.get(i), list.get(j));
                ans = (ans > num) ? num : ans;
            }    
        }
        return ans;
    }
    public static int Checkshortest(List<Pointer> list, int x, int y){
        if(y - x <= 2){
            return Findshortest(list, x, y);
        }
        int mid = (x + y) / 2;
        int left = Checkshortest(list, x, mid);
        int right = Checkshortest(list, mid + 1, y);
        int num = Math.min(left, right);
        List<Pointer> list_short = new ArrayList<Pointer>();
        for(int i = x; i <= y; i++){
            int distanceX = list.get(i).getX() - list.get(mid).getX();
            int distanceY = list.get(i).getY() - list.get(mid).getY();
            if(distanceX * distanceX < num){
                if(distanceX == 0 && distanceY == 0 && i != mid){
                    return 0;
                }
                list_short.add(list.get(i));
            }
        }
        /*
        for(int i = 0; i < list_short.size(); i++){
            System.out.println("D: " + list_short.get(i).getX() + " " + list_short.get(i).getY());
        }
        */
        Collections.sort(list_short, new PointerY());
        int m = list_short.size();
        for(int i = 0; i < m - 1; i++){
            for(int j = i + 1; j < m; j++){
                int distance = list_short.get(j).getY() - list_short.get(i).getY();
                if(distance * distance < num){
                    int b = distance(list_short.get(i), list_short.get(j));
                    num = (num > b) ? b : num;
                } else {
                    break;
                }
            }
        }
        return num;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Pointer> pointer = new ArrayList<Pointer>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            pointer.add(new Pointer(X, Y));
        }
        Collections.sort(pointer);
        System.out.println(Checkshortest(pointer, 0, N - 1));
        br.close();
        bw.close();
    }
}