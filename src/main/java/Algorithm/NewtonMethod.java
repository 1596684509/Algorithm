package Algorithm;

public class NewtonMethod {

    private double x;
    private double result;

    /**
     * 牛顿法
     * Xn+1 = Xn+(a/Xn) / 2
     */
    public NewtonMethod(double x) {

        this.x = x;

    }

    /**
     * 计算
     * @param precision 精度
     */
    public void calculate(double precision) {

        if(x == 0) {

            result = 0;
            return;

        }

        //设置初始值
        double initValue = x / 2;
        double next;

        while(true) {

            //带入公式计算
            next = (initValue + x / initValue) / 2;

            //通过将计算的结果与初始值进行减法运算得到结果
            //精度值
            if(Math.abs(next - initValue) < precision) {

                result = next;
                return;

            }

            initValue = next;

        }

    }

    public double getResult() {

        return result;

    }

}
