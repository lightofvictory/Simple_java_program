public class Day_2 {

    public static void main(String[] args) {
// given number is divided by its last digits
        int a = 12;
        int rev = 1;
       int count=0;
        int last_number = 0;
        while (a > 0) {
            last_number = a % 10;
            if(a%last_number==0){
                count++;
            }
        rev = (rev * 10) + last_number;
        a = a / 10;
    }
        System.out.println(count);
    }
}
