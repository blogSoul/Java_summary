import java.util.Scanner;

public class Sample {
    public static void main(String[] args){
        String p = "()()((()))";
        int i = 0, countfirst = 0;
        for(i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(')
                countfirst++;
            else if(p.charAt(i)== ')')
                countfirst++;
        }
        
    }
}
/*
print : 괄호안 내용을 단순히 출력. 개행문자(=줄바꿈문자=\n) 포함안됨.
printf : C에서의 printf와 동일. %d, %s 등을 쓰기위해 사용. 개행문자 포함X
println : 괄호안 내용을 출력한 후 마지막에 개행문자가 포함되어 있어 출력후 한 줄 띄워짐.
*/
