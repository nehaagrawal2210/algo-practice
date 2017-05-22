package leetcode;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/21/17.
 */
public class FractionAdditionAndSubtraction extends TestCase {

    class Fraction {
        int numerator;
        int denominator;

        public Fraction sum(Fraction f1, Fraction f2) {
            Fraction f3 = new Fraction();
            f3.denominator = f1.denominator * f2.denominator;
            f3.numerator = (f1.numerator * f2.denominator) + (f2.numerator * f1.denominator);
            makeIrreducible(f3);
            if(f3.denominator < 0) {
                f3.denominator*=-1;
                f3.numerator*=-1;
            }
            return f3;
        }

        public Fraction makeIrreducible(Fraction f1) {
            int hcf = getHCF(f1.numerator, f1.denominator);
            f1.numerator /= hcf;
            f1.denominator /= hcf;
            return f1;
        }

        public int getHCF(int a, int b) {
            if (b == 0) return a;
            return getHCF(b, a % b);
        }

        public Fraction() {

        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }

    public String fractionAddition(String expression) {
        if(expression.length()==0) return expression;
        Fraction sum = new Fraction(0,1);
        if(expression.charAt(0)!='-' && expression.charAt(0)!='+') expression = "+"+expression;
        expression+="+";
        int numerator,denominator,signIndex=0;
        String[] fractions;
        for (int i = 0; i < expression.length()-1; i=signIndex) {
            int ngtive = expression.substring(i+1).indexOf('-');
            int pstive = expression.substring(i+1).indexOf('+');
            if(ngtive>0 && pstive>0) signIndex = Math.min(ngtive,pstive);
            else if(ngtive>0) signIndex = ngtive;
            else if(pstive>0) signIndex = pstive;
            signIndex+=1+i;
            fractions = expression.substring(i+1,signIndex).split("/");
            numerator = Integer.parseInt(fractions[0]);
            denominator = Integer.parseInt(fractions[1]);
            if(expression.charAt(i)=='-') numerator*=-1;
            sum = sum.sum(sum,new Fraction(numerator,denominator));
        }
        return sum.toString();
    }

    public String fractionAddition1(String exp)
    {
        String[] fractions,nums;
        String exp1= exp;
        if(exp1.charAt(0)=='-') exp1 = exp1.substring(1);
        else exp = "+"+exp;
        fractions = exp1.split("(\\+)|(-)");
        int i=0;
        Fraction sum = new Fraction(0,1);
        for(String s: fractions)
        {
            nums=s.split("/");
            int numerator = Integer.parseInt(nums[0]);
            int denominator = Integer.parseInt(nums[1]);
            if(exp.charAt(i)=='-') numerator*=-1;
            sum = sum.sum(sum,new Fraction(numerator,denominator));
            i=i+1+s.length();
        }
        return sum.toString();
    }

    public void testSumFraction()
    {
        assertEquals("-1/6",fractionAddition("1/3-1/2"));
        assertEquals("29/18",fractionAddition("-5/2+10/3+7/9"));
        System.out.println(fractionAddition1("-5/2+10/3+7/9"));
    }
}
