이렇게 짜지 마세요!
```java
class Solution {
    public int factorial(int n){
        if(n >= 0 && n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }
    public int count(int n){
        int i, num = n / 2, num2 = n % 2, answer = 0;
        for(i = num2; i <= n; i += 2) {
            answer += factorial(num + i) / (factorial(num) * factorial(i));
            num -= 1;
        }
        return answer;
    }
    public int solution(int n) {
        return count(n % 1000000007);
    }
}
```

이렇게 짜도록 하세요!

```java
class Solution {
    public int solution(int n) {
        int i, a = 1, b = 1, c;
        for(i = 0; i < n - 1; i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }
}
```