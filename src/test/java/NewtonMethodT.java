import Algorithm.NewtonMethod;
import org.junit.jupiter.api.Test;

public class NewtonMethodT {

    @Test
    public void t1() {

        NewtonMethod newtonMethod = new NewtonMethod(79);
        newtonMethod.calculate(1e-6);
        System.out.println(newtonMethod.getResult());

    }

}
