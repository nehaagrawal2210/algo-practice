package codechef.snackdown2017;

/**
 * Created by neagrawa on 5/22/17.
 */
public class TempleLand {
    public static void main(String[] args) throws java.io.IOException{
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        java.util.StringTokenizer st;
        for (int i = 0; i < testCases; i++) {
            int l = Integer.parseInt(br.readLine());
            int heights[] = new int[l];
            st = new java.util.StringTokenizer(br.readLine());
            for (int j = 0; j < l; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }
            if(isTemple(heights)) System.out.println("yes");
            else System.out.println("no");
        }
    }

    public static boolean isTemple(int[] heights)
    {
        if(heights.length%2==0 || heights[0]!=1 || heights[heights.length-1]!=1)
            return false;
        int left=0,right=heights.length-1;
        while (left<right)
        {
            if(heights[left]+1 != heights[left+1] || heights[left]!=heights[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
