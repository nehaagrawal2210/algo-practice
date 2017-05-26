package codechef.snackdown2017;

/**
 * Created by neagrawa on 5/22/17.
 */
public class SnakeProcession {
    public static void main(String[] args) throws java.io.IOException{
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        String snake;
        for (int i = 0; i < testCases; i++) {
            int l = Integer.parseInt(br.readLine());
            snake = br.readLine();
            snake = snake.replace(".","");
            if(isValidProcession(snake)) System.out.println("Valid");
            else System.out.println("Invalid");
        }
    }

    public static boolean isValidProcession(String procession)
    {
        if(procession.length()%2!=0)return false;
        for (int i = 0; i < procession.length()-1; i+=2) {
            if(procession.charAt(i)!='H') return false;
            if(procession.charAt(i+1)!='T')return false;
        }
        return true;
    }
}
