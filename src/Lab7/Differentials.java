package Lab7;

import javafx.util.Pair;

public class Differentials {
    public Pair<double[], double[]> rungeKutta2(double x0, double xn, double y0, double h) {
        int n = (int) ((xn-x0)/h);
        double[] X = new double[n];
        double[] Y = new double[n];
        X[0] = x0;
        Y[0] = y0;
        for (int i = 1; i < n; i++) {
            double k2 = h*derivF(X[i-1]+h/2);
            Y[i] = Y[i-1] + k2;
            X[i] = X[i-1] + h;
        }
        return new Pair<>(X,Y);
    }
    private double derivF(double x) {
        return Math.pow(Math.E, x) - 1;
    }
}
