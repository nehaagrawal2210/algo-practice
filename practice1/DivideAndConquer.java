package practice1;

public class DivideAndConquer {

    public double pow(float n, int pow) {
        double ans = powN(n,pow);
        if(pow<0){
            return 1.0/ans;
        }
        return ans;
    }

    private double powN(float n, int p) {
        if(n == 0){
            return 1.0;
        }

        double ans = powN(n,p/2);
        if((p & 1) == 0){
            return ans*ans;
        }
        else{
            return n * ans * ans;
        }
    }

    public static void main(String[] args) {
        DivideAndConquer dv = new DivideAndConquer();
        System.out.println(dv.pow(2, 10));
    }


}
