package Lab7;

public class Integrals {
    private double f(double x) {
        return Math.sqrt(1 + x*x + Math.sin(x));
    }
    public double rectangleMehodL(double a, double b, double h) {
        double sum = .0;
        int n = (int) ((b-a) / h);
        for (int i = 0; i < n; i++) {
            sum += f(a + i * h);
        }
        return sum * h;
    }
    public double rectangleMehodR(double a, double b, double h) {
        double sum = .0;
        int n = (int) ((b-a) / h);
        for (int i = 1; i <= n; i++) {
            sum += f(a + i * h);
        }
        return sum * h;
    }
    public double rectangleMehodM(double a, double b, double h) {
        double sum = .0;
        double x = a + h/2;
        int n = (int) ((b-a) / h);
        for (int i = 0; i < n; i++) {
            sum += f(x + i * h);
        }
        return sum * h;
    }
    public double trapezoidMethod(double a, double b, double h) {
        double sum = (f(a) + f(b)) / 2 ;
        int n = (int) ((b-a) / h);
        for (int i = 1; i < n; i++) {
            sum += f(a + i * h);
        }
        return sum * h;
    }
    public double simpsonsMethod(double a, double b, double h) {
        int n = (int) ((b-a) / h);
        double sum = f(a) + f(b);
        double subSum = 0;
        double x;

        for (int i = 1; i < n; i+=2) {
            x = a + i * h;
            subSum += f(x);
        }

        subSum *= 4;
        sum += subSum;
        subSum = 0;

        for (int i = 2; i < n - 1; i+=2) {
            x = a + i * h;
            subSum += f(x);
        }

        subSum *= 2;
        sum += subSum;
        return sum * h/3;
    }
}
