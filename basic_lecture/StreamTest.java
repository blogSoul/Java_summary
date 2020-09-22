import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
// 패키지를 만들 때, package라는 키워드를 사용합니다. 
// Ex) package jump2java.house;

public class StreamTest {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in; // byte
        InputStreamReader reader = new InputStreamReader(in); // char
        BufferedReader br = new BufferedReader(reader); // String
        
        int a;
        a = in.read(); // read method는 1byte만 읽습니다.
        System.out.println(a);
        // Stream이란? 
        // 파일 데이터 (파일은 그 시작과 끝이 있는 데이터의 스트림이다.)
        // HTTP 응답 데이터 (브라우저가 요청하고 서버가 응답하는 HTTP 응답 데이터도 스트림이다.)
        // 키보드 입력 (사용자가 키보드로 입력하는 문자열은 스트림이다.)
        byte[] b = new byte[3];
        in.read(b);
        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);
        // 바이트 입력 스트림 사용 

        char[] c = new char[3];
        reader.read(c);
        System.out.println(c);
        // 문자로 입력 스트림 사용(문자열 길이만큼 입력 가능)
        
        String d = br.readLine();
        System.out.println(d);

        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next());
        sc.close(); // 입력을 사용하면 닫아줄 수 있도록 합니다.
        // next - 단어 
        // nextLine - 단어 
        // nextInt - 정수 
        
        // System.out은 PrintStream 클래스의 객체이다.
        // System.err는 오류메시지를 출력할 경우에 사용됩니다.
    }
}