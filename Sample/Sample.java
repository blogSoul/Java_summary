import java.util.ArrayList;

public class Sample {
    // 주석은 이렇게 사용합니다.
    // class이름과 파일 이름을 같이 맞출 수 있도록 합니다.
    public static void main(final String[] args) {
        char b = 'a';
        boolean isTest= false;
        String c = "Hi asd";
        System.out.println("Helloworld");
        System.out.println(b);
        System.out.println(c);

        ArrayList<String> pocket = new ArrayList<String>();
        pocket.add("paper");
        pocket.add("handphone");
        if(pocket.contains("money"))
            System.out.println("택시!");
        else
            System.out.println("걷기!");
        System.out.println(pocket.contains("money"));

        int month = 8;
        String monthString = "";
        switch(month){
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        System.out.println(monthString);

        int a = 0;
        while(true){
            if(a >= 10)
                break;
            a++;
            if(a % 2 == 0)
                continue;
            System.out.println(a+"\n");
        }

        int[] marks = {90, 40, 67, 45, 80};
        for(int i=0; i<marks.length; i++) {
            if (marks[i] >= 60) {
                System.out.println((i+1)+"번 학생은 합격입니다.");
            }else {
                System.out.println((i+1)+"번 학생은 불합격입니다.");
            }
        }
    }
}