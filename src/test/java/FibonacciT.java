import Algorithm.Fibonacci;
import org.junit.jupiter.api.Test;

public class FibonacciT {

    @Test
    public void t1() {

        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.fibonacci(15));
        System.out.println(fibonacci.fibonacci2(15));

    }

}
