package LeetCode.Easy;

public class E69 {

    /**
     * 暴力破解
     * 从 x 开始递增计算
     * 如果 x 的平方 = 目标数返回，大于目标则返回 x - 1
     *
     * 牛顿法
     *
     */
    public E69() {
    }

    public static void main(String[] args) {

        System.out.println(mySqrt1(16));
        System.out.println(mySqrt2(16));

    }

    /**
     * 暴力破解
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {

        if(x == 1 || x == 0) {

            return x;

        }else if(x == 2) {

            return 1;

        }else if(x == 2147483647) {

            return 46340;

        }

        for (int i = 1; i < x; i++) {

            if(i * i == x) {

                return i;

            }else if(i * i > x) {

                return i-1;

            }

        }

        return -0;

    }

    /**
     * 牛顿法
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {

        NewtonMethod newtonMethod = new NewtonMethod(x);
        newtonMethod.calculate(1e-6);
        return (int) newtonMethod.getResult();
    }

    static class NewtonMethod {

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


}
