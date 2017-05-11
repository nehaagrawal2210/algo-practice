package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 2/6/2017.
 */
public class CielAndReceipt {


    public static int getMinMenu(int price)
    {
        int menuItems=0;
        while (price>=2048)
        {
            price-=2048;
            menuItems++;
        }
        while (price!=0)
        {
            double logVal=Math.floor(Math.log(price)/Math.log(2));
            price=(int) (price-Math.pow(2,logVal));
            menuItems++;
        }
        return menuItems;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int price=Integer.parseInt(br.readLine());
            System.out.println(getMinMenu(price));
        }
    }
}
