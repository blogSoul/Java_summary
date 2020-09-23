public class tryTest {
    public void shouldBeRun() {
        System.out.println("ok thanks.");
    }
    public void sayNick(String nick) {
        try {
            if("fool".equals(nick)) {
                throw new FoolException();
            } // throw로 예외를 발생시킬 수 있습니다.
            System.out.println("당신의 별명은 " + nick + " 입니다.");
        } catch(FoolException e) {
            System.out.println(" Catch FoolException");
        } 
    }
    public static void main(String[] args){
        tryTest test = new tryTest();
        int c;
        try {
            c = 4 / 0;
        } catch (ArithmeticException e) {
            c = -1;
        } finally {
            test.shouldBeRun();
        }

        test.sayNick("fool");
        test.sayNick("genious"); 
        // 프로그래밍 시 Exception을 처리하는 위치는 대단히 중요하다.
        // Exception을 sayNick에서 처리했기 때문에 두 코드가 실행이 가능한 것입니다.
    }
}
// 트랜잭션(Transaction)
// 트랜잭션은 하나의 작업 단위를 의미하고 아래와 같은 qsueduo 코드를 실행하면 포장, 영수증 발행, 발송이 하나의 작업단위로 만들 수 있습니다.
/*
Ex)
상품발송() {
    try {
        포장();
        영수증발행();
        발송();
    }catch(예외) {
       모두취소();
    }
}

포장() throws 예외 {
   ...
}

영수증발행() throws 예외 {
   ...
}

발송() throws 예외 {
   ...
}
*/
