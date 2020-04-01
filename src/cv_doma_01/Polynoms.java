
package cv_doma_01;

/**
 * knihovni trida, library class
 * @author Petr-PC
 */
public class Polynoms {
    
    private Polynoms(){ // nemohl se vytvorit objekt
        
    }
    
    public static Polynom sum(Polynom a, Polynom b){
        boolean isABigger = a.getDegree() > b.getDegree();
        Polynom max = isABigger? a : b; //Math.max(a.getDegree(), b.getDegree());
        Polynom min = isABigger? b : b;
        
        double[] sumCoef = new double[max.getDegree() + 1];
        // 6 0 3 5
        // +
        // 1 3 6
        // 7 3 9 5
        for (int i = 0; i < max.getDegree() + 1; i++) {
            sumCoef[i] = max.getCoefAt(i);
        }
        for (int i = 0; i < min.getDegree() + 1; i++) {
            sumCoef[i] = sumCoef[i] + min.getCoefAt(i);
        }
        return Polynom.getInstanceReverted(sumCoef);
    }
    

    public static void main(String[] args) {
        Polynom p1 = Polynom.getInstance(5, 3 , 0, 6);
        Polynom p2 = Polynom.getInstance(6, 3, 1);
        System.out.println(Polynoms.sum(p1, p2));
        
    }
    
}
