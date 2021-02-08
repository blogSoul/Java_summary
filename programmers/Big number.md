## Solution

```java
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> arr = new ArrayList<String>();
        for(Integer i : numbers){
            arr.add(Integer.toString(i));
        }
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if(arr.get(0).compareTo("0") == 0){
            return "0";
        }
        for(String i : arr){
            answer += i;
        }
        return answer;
    }
}
```

## fail

```java
import java.util.*;

class Solution {
    public int Compare(String o1, String o2){ 
        int o1_last = o1.length(), o2_last = o2.length(); 
        int size = Math.max(o1_last, o2_last);
        for(int i = 0; i < size; i++){
            char p1 = (i < o1_last) ? o1.charAt(i) : o1.charAt(o1_last - 1);
            char p2 = (i < o2_last) ? o2.charAt(i) : o2.charAt(o2_last - 1);
            //System.out.println("D " +  p1 + " " + p2);
            if(p1 > p2){
                return -1;
            } else if(p1 < p2){
                return 1;
            }
        }
        return -1;
    }
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> arr = new ArrayList<String>();
        for(Integer i : numbers){
            arr.add(Integer.toString(i));
        }
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                //System.out.println(o1 + " " + o2 + " " + Compare(o1, o2));
                return Compare(o1, o2);
            }
        });
        for(String i : arr){
            answer += i;
        }
        return answer;
    }
}
```
