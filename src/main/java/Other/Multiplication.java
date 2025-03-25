package Other;

public class Multiplication {

    public int multiply(int a, int b) {

        int result = 0;
        while (b != 0) {

            if((b & 1) == 1) {

                result += a;

            }

            b >>= 1;
            a <<= 1;

        }

        return result;

    }

}
