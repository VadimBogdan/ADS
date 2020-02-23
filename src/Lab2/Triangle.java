package Lab2;

import java.util.Random;

public class Triangle {
    public Point A;

    public Point B;

    public Point C;

    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public Triangle() {
        Random rand = new Random();
        double AB;
        double BC;
        double CA;

        A = new Point(0, 0);
        B = new Point(0, 0);
        C = new Point(0, 0);


        do {
            A.x = rand.nextInt(100);
            A.y = rand.nextInt(100);
            B.x = rand.nextInt(100);
            B.y = rand.nextInt(100);
            C.x = rand.nextInt(100);
            C.y = rand.nextInt(100);

            AB = Math.sqrt(Math.pow(B.x - A.x, 2) + Math.pow(B.y - A.y, 2));
            BC = Math.sqrt(Math.pow(C.x - B.x, 2) + Math.pow(C.y - B.y, 2));
            CA = Math.sqrt(Math.pow(A.x - C.x, 2) + Math.pow(A.y - C.y, 2));

        } while (AB + BC < CA);
    }

    public double square() {
        double p = perimeter() / 2;

        double AB = Math.sqrt(Math.pow(B.x - A.x, 2) + Math.pow(B.y - A.y, 2));
        double BC = Math.sqrt(Math.pow(C.x - B.x, 2) + Math.pow(C.y - B.y, 2));
        double CA = Math.sqrt(Math.pow(A.x - C.x, 2) + Math.pow(A.y - C.y, 2));

        return Math.sqrt(p * (p - AB) * (p - BC) * (p - CA));
    }

    public double perimeter() {
        double AB = Math.sqrt(Math.pow(B.x - A.x, 2) + Math.pow(B.y - A.y, 2));
        double BC = Math.sqrt(Math.pow(C.x - B.x, 2) + Math.pow(C.y - B.y, 2));
        double CA = Math.sqrt(Math.pow(A.x - C.x, 2) + Math.pow(A.y - C.y, 2));

        return AB + BC + CA;
    }

    @Override
    public String toString() {
        return String.format("Triangle with square: %1$.2f, perimeter: %2$.2f", square(), perimeter());
    }

    public static class Point {
        public double x;
        public double y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
