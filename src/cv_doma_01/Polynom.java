package cv_doma_01;

import java.util.Arrays;

/**
 *
 * @author Petr-PC
 */
public class Polynom {
    //data
    //5x^3 + 3x^2 + 6 [6 0 3 5]

    private double[] coef;

    //konstruktory
//    [6 0 3 5]
//    [5 3 0 6]
//    6, 0, 3, 5
//    5, 3, 0, 6
    private Polynom(double[] coef) {
        double[] coefTemp = new double[coef.length];   //defenzivni kopie, aby byly privatni i hodnoty pole
        System.arraycopy(coef, 0, coefTemp, 0, coef.length);
        this.coef = coefTemp;
    }

    //tovarni factory metoda
    public static Polynom getInstanceReverted(double[] coef) {  // [6 0 3 5]
        return new Polynom(coef);
    }

    public static Polynom getInstance(double... coef) {  // 5, 3, 0, 6
        double[] coefTemp = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            coefTemp[coefTemp.length - 1 - i] = coef[i];
        }
        return new Polynom(coefTemp);
    }

    // Metody
    //TODO
//    5x^3 + 3x^2 + 6 pro x = 1 y = 5 + 3 + 6 = 14
    // pouzit Hornerovo schema
    public double computeValue(double x) {   //domaci ukol
        double hodnota = coef[coef.length - 1];
        for (int i = coef.length - 1; i > 0; i--) {
            hodnota = hodnota * x + coef[i - 1];
        }
        return hodnota;
    }

    //gettery
    public double getCoefAt(int exponent) {
        return coef[exponent];
    }

    public double[] getAllCoef() {
        return Arrays.copyOf(coef, coef.length);
    }

    public int getDegree() {
        return coef.length - 1;
    }

    //TODO vypsat matematicky spravne 5x^3 + ... kdyz bude 0, tak nevypsat  // 2 cast domaci ulohy
    @Override
    public String toString() {
        int mocnina = coef.length - 1;
        for (int i = 0; i < coef.length; i++) {
            if (coef[i] == 0) {
                mocnina--;
                i++;
            }
            if (mocnina == 0) {
                System.out.print(coef[i] + " ");
            } else {
                System.out.print(coef[i] + "x" + "^" + (mocnina) + " ");
            }
            mocnina--;
        }

        return "Polynom{coef=" + Arrays.toString(coef) + "}";
    }

    //5x^3 !derivace! 15x^2
    public Polynom derivate() {
        double[] coefD = new double[this.coef.length - 1]; //coef derivace je o jedno mensi
        for (int i = 0; i < coefD.length; i++) {
            coefD[i] = coef[i + 1] * (i + 1);
        }
        return new Polynom(coefD);

    }

    // TODO zamyslet se nad integralem, bonusova uloha, vypocet integralu s rozsahem a a b
    public double integrate(double a, double b) {
        return 0;
    }

    public static void main(String[] args) {
        double[] a = {6, 0, 3, 5};
        Polynom p1 = Polynom.getInstanceReverted(a);
        Polynom p2 = getInstance(a);
//        System.out.println(p1);
//        System.out.println(p1.getCoefAt(3));
//        System.out.println(p1.derivate());
//        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p2.computeValue(1));
    }

}
