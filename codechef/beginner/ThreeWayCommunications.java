package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class ThreeWayCommunications {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        StringTokenizer st;

        int r,x1,y1,x2,y2,x3,y3,dist1,dist2,dist3;
        for (int i = 0; i < testCases; i++) {
            r=Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x3=Integer.parseInt(st.nextToken());
            y3=Integer.parseInt(st.nextToken());

            //calculate dist
            dist1=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
            dist2=(x3-x2)*(x3-x2)+(y3-y2)*(y3-y2);
            dist3=(x3-x1)*(x3-x1)+(y3-y1)*(y3-y1);

            if(((dist1<=r*r) && (dist2<=r*r)) || (((dist1<=r*r) && (dist3<=r*r))) || (((dist2<=r*r) && (dist3<=r*r))))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
