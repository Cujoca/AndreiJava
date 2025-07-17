public class Hybrid10 {

    public static void doThing (int num) {
        int last, middle, result = 0, temp = num;

        // set the last 2 digits
        last = (num%10)*10;
        temp /=10;
        last += temp%10;
        temp /=10;

        // set the middle 2 digits
        middle = (temp%10)*10;
        temp /=10;
        middle += temp%10;

        // reset temp to original num value
        temp = num;
        // add all digits to resultant variable
        for (int i = 0; i < 6; i++) {
            result *= 10;
            result += temp%10;
            temp /= 10;
        }

        if (result >= 100) {
            temp = (result%10)*10;
            result /= 10;
            temp += result%10;
        }

        System.out.printf("Last 2 digits: %d, Middle 2 digits: %d, Result: %d\n", last, middle, temp);
    }

    public static void main(String[] args) {
        for (int i = 145623; i < 145724; i++) {
            doThing(i);
        }
    }
}
