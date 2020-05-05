package Lab7;

public class Equations {
    private double f(double x){
        return x*x - 2*x + Math.log(x);
    }
    public double halfDivision(double a, double b, double eps) {
        double x = (a+b)/2;
        while (Math.abs(f(x)) > eps) {
            if (f(a)*f(x) < 0) {
                b = x;
            } else if (f(b)*f(x) < 0) {
                a = x;
            }
            x = (a+b) / 2;
        }
        return x;
    }
    private double firstDerivatetive(double x) {
        return  2*x-2+1/x;
    }
    private double secondDerivative(double x) {
        return 2-1/(x*x);
    }
    public double methodNewton(double a, double b, double eps) {
        double x;
        if (f(a) * secondDerivative(a) > 0) {
            x = a;
        } else {
            x = b;
        }
        while (Math.abs(f(x)) > eps) {
            x -= f(x)/firstDerivatetive(x);
        }
        return x;
    }
    public double methodChord(double a, double b, double eps) {
        double x;
        if (f(a)*secondDerivative(a) > 0) {
            x = b;
        } else {
            x = a;
        }
        if (f(a)*secondDerivative(a) > 0) {
            while (Math.abs(f(x)) > eps) {
                x = x - (x-a) * f(x)/(f(x)-f(a));
            }
        } else {
            if (f(b)*secondDerivative(b) > 0) {
                while (Math.abs(f(x)) > eps) {
                    x = x - (b-x) * f(x)/(f(b)-f(x));
                }
            }
        }
        return x;
    }
}
