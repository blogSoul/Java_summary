# 📕 Solution

```java
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0, arr_size = citations.length, start = 0;
        Arrays.sort(citations);
        for(int i = 0; i < arr_size; i++){
            if(start != citations[i]){
                start = citations[i];
                if(citations[i] >= arr_size - i){
                    answer = arr_size - i;
                    break;
                }
            }
        }
        return answer;
    }
}
```

## ❌ fail

```java

```

# 📑 memo

.
