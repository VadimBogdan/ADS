package Lab7;

import javafx.util.Pair;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lvl 1
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введіть a");
//        double a = scanner.nextDouble();
//        System.out.println("Введіть b");
//        double b = scanner.nextDouble();
//        System.out.println("Введіть h");
//        double h = scanner.nextDouble();
//        Integrals integrals = new Integrals();
//        System.out.println("Метод правих прямокутників " + integrals.rectangleMehodL(a, b, h));
//        System.out.println("Метод лівих прямокутників " + integrals.rectangleMehodR(a, b, h));
//        System.out.println("Метод серединних прямокутників " + integrals.rectangleMehodM(a, b, h));
//        System.out.println("Метод трапецій " + integrals.trapezoidMethod(a, b, h));
//        System.out.println("Метод сімпсона " + integrals.simpsonsMethod(a, b, h));
        // Lvl 2
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введіть a");
//        double a = scanner.nextDouble();
//        System.out.println("Введіть b");
//        double b = scanner.nextDouble();
//        Equations equations = new Equations();
//        System.out.println("Метод половинчастого ділення " + equations.halfDivision(a, b, 0.0001));
//        System.out.println("Метод дотичних " + equations.methodNewton(a, b, 0.0001));
//        System.out.println("Метод хорд " + equations.methodChord(a, b, 0.0001));
        // Lvl 3
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть x0");
        double x0 = scanner.nextDouble();
        System.out.println("Введіть xn");
        double xn = scanner.nextDouble();
        System.out.println("Введіть y0");
        double y0 = scanner.nextDouble();
        System.out.println("Введіть h");
        double h = scanner.nextDouble();
        Differentials differentials = new Differentials();
        System.out.println("Метод Рунге-Кутта 2-го порядку");
        Pair<double[], double[]> p = differentials.rungeKutta2(x0, xn, y0, h);
        double[] X = p.getKey();
        double[] Y = p.getValue();
        for (int i = 0; i < X.length; i++) {
            System.out.println(String.format("%.1f %.1f", X[i], Y[i]));
        }
    }
}
