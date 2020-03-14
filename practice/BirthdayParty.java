package practice;

public class BirthdayParty {
    public static void main(String[] args) {
        System.out.println(getLastChildIndex(9, 16, 2));
    }

    private static int getLastChildIndex(int n, int t, int startId) {
        int lastRoundToys = t % n;
        if(lastRoundToys == 0) {
            return n;
        }
        int lastKid = (startId + lastRoundToys - 1) % n;
        return lastKid;
    }
}
