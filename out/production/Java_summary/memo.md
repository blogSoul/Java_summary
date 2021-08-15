```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
```

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static final long REMAINDER = 1000000007;
    public static long[] tree, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new long[4 * N];
        Arrays.fill(tree, 1);
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0, N - 1, 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1){
                update(0, N - 1, 1, b - 1, c, arr[b - 1]);
                arr[b - 1] = c;
            } else if(a == 2){
                sb.append(multiple(0, N - 1, 1, b - 1, c - 1) % REMAINDER).append("\n");
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();0
    }

    // start: 시작 인덱스, end: 끝 인덱스
    private static long init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start] % REMAINDER;
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, 2 * node) * init(mid + 1, end, 2 * node + 1) % REMAINDER;
    }

    // left ~ right : 구간 곱을 구하고자 하는 범위
    private static long multiple(int start, int end, int node, int left, long right){
        if(start > right || end < left) return 1;
        if(left <= start && end <= right) return tree[node] % REMAINDER;
        int mid = (start + end) / 2;
        return multiple(start, mid, 2 * node, left, right) * multiple(mid + 1, end, 2 * node + 1, left, right) % REMAINDER;
    }

    // index : 구간 곱을 수정하고자 하는 노드, dif: 수정할 값, before : 이전의 값
    private static void update(int start, int end, int node, int index, long dif, long before){
        if(start > index || end < index) return;
        tree[node] = (before == 0) ? dif % REMAINDER : tree[node] * dif / before % REMAINDER;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, 2 * node, index, dif, before);
        update(mid + 1, end, 2 * node + 1, index, dif, before);
    }
}
```