package misc;

/**
 * Created by neha on 1/30/2017.
 */
public class PrimeNo {

    public static void main(String[] args) {
        int a=23,d=44,t=7;
        System.out.println(checkPrime(a));
        System.out.println(checkPrime(d));
        System.out.println(checkPrime(t));
        sieveOfErastothenes(20);
    }

    public static boolean checkPrime(int m)
    {
        if(m<2)
            return false;
        if(m==2)
            return true;
        if(m%2==0)
            return false;
        for (int i = 3; i*i <= m ; i+=2) {
            if(m%i==0)
                return false;
        }
        return true;
    }

    public static void sieveOfErastothenes(int m)
    {
        boolean prime[]=new boolean[m+1];
        prime[0]=false;
        prime[1]=false;
        prime[2]=true;

        //make all others true
        for (int i = 3; i <m ; i++) {
            prime[i]=true;
        }

        for (int i = 2; i*i<=m ; i++) {
            if(prime[i]==true)
            {
                //mark all multiples false
                for (int j = i*2; j <=m ; j+=i) {
                    prime[j]=false;
                }
            }
        }

        for (int i = 1; i <=m ; i++) {
            if(prime[i])
                System.out.println(i);
        }
    }
}
