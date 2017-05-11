package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 1/24/2017.
 */
public class ATM {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int withdrawAmt= Integer.parseInt(st.nextToken());
        double balanceAmt= Double.parseDouble(st.nextToken());

        if(withdrawAmt%5==0 && withdrawAmt+0.5<=balanceAmt)
            System.out.printf("%.2f",balanceAmt-withdrawAmt-0.5);
        else
            System.out.printf("%.2f",balanceAmt);

    }
}
