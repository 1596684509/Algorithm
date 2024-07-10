import Algorithm.NewtonMethod;
import org.junit.jupiter.api.Test;

public class NewtonMethodT {

    @Test
    public void t1() {

        NewtonMethod newtonMethod = new NewtonMethod(1);
        newtonMethod.calculate(1e-1);
        System.out.println(newtonMethod.getResult());
        newtonMethod.calculate(1e-6);
        System.out.println(newtonMethod.getResult());

    }

}
