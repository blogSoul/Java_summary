```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Objects;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    public static boolean pairEquals(Pair a, Pair b) {
        if (a.x == b.x && a.y == b.y) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pair a = new Pair(1, 2);
        Pair b = new Pair(1, 2);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(Objects.deepEquals(a, b));
        System.out.println(pairEquals(a, b));
        System.out.println(Objects.compare(a, b, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.x < b.x) {
                    return -1;
                } else if (a.x > b.x) {
                    return 1;
                } else {
                    if (a.y < b.y) {
                        return -1;
                    } else if (a.y > b.y) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }));
        br.close();
    }
}
```
