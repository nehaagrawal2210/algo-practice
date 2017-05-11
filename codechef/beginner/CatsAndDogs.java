package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 1/23/2017.
 */
public class CatsAndDogs {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        int cats,dogs,legs;
        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cats=Integer.parseInt(st.nextToken());
            dogs=Integer.parseInt(st.nextToken());
            legs=Integer.parseInt(st.nextToken());

            if(isValidLegCount(cats,dogs,legs))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    public static boolean isValidLegCount(int cats,int dogs,int legs)
    {
        int cats_ = cats < dogs * 2 ? 0 : cats - dogs * 2;
        if(legs%4==0 && legs/4<=(cats+dogs) && legs/4>=cats_+dogs)
            return true;
        return false;
    }
}
