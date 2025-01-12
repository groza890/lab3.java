package ex1;

import static java.lang.Math.hypot;

public class Parabola {
    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] varfParabola() {
        double delta = b*b-4*a*c;
        double[] v = { -b/2*a, -delta/4*a};
        return v;
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    public double[] mijlocDistantaVarfuri(Parabola f1) {
        double[] v1 = this.varfParabola();
        double[] v2 = f1.varfParabola();
        double[] mijloc = { (v1[0] + v2[0])/2, (v1[1] + v2[1])/2 };
        return mijloc;
    }

    public static double[] mijlocDistantaVarfuri_static(Parabola f1, Parabola f2) {
        double[] v1 = f1.varfParabola();
        double[] v2 = f2.varfParabola();
        double[] mijloc = { (v1[0] + v2[0])/2, (v1[1] + v2[1])/2 };
        return mijloc;
    }

    public double distantaVarfuri(Parabola f1) {
        double[] v1 = this.varfParabola();
        double[] v2 = f1.varfParabola();
        return hypot(v1[0] - v2[0], v1[1] - v2[1]);
    }

    public static double distantaVarfuri_static(Parabola f1, Parabola f2) {
        double[] v1 = f1.varfParabola();
        double[] v2 = f2.varfParabola();
        return hypot(v1[0] - v2[0], v1[1] - v2[1]);
    }
}