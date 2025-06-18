import java.lang.reflect.Array;
import java.util.ArrayList;

public class SingleList<T> {
    T value;
    SingleList<T> tail;


    public static int fib (int index) {
        System.out.println(index);
        if (index == 0) return 0;
        if (index == 1 || index == 2) return 1;
        return fib(index - 1) + fib(index - 2);
    }
    public static void main (String[] args) {
        System.out.println(fib(10));



    }

}
