package leetcode;

import junit.framework.TestCase;

import java.util.HashMap;

/**
 * Created by neagrawa on 5/11/17.
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/#/description
 */
public class ReconstructOriginalDigitsFromEnglish extends TestCase {
    public String originalDigits1(String s) {

        String result="";
        int[] digitCount = new int[10];
        HashMap<Character,Integer> characterMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            characterMap.put(c,characterMap.getOrDefault(c,0)+1);
        }

        int currDigitCount;
        if(characterMap.getOrDefault('z',0)>0) {
            currDigitCount = characterMap.get('z');
            digitCount[0] = currDigitCount;
            characterMap.put('e',characterMap.get('e')-currDigitCount);
            characterMap.put('r',characterMap.get('r')-currDigitCount);
            characterMap.put('o',characterMap.get('o')-currDigitCount);
            characterMap.remove('z');
        }
        if(characterMap.getOrDefault('w',0)>0){
            currDigitCount = characterMap.get('w');
            digitCount[2] = currDigitCount;
            characterMap.put('t',characterMap.get('t')-currDigitCount);
            characterMap.put('o',characterMap.get('o')-currDigitCount);
            characterMap.remove('w');
        }
        if(characterMap.getOrDefault('x',0)>0){
            currDigitCount = characterMap.get('x');
            digitCount[6] = currDigitCount;
            characterMap.put('s',characterMap.get('s')-currDigitCount);
            characterMap.put('i',characterMap.get('i')-currDigitCount);
            characterMap.remove('x');
        }

        if(characterMap.getOrDefault('g',0)>0){
            currDigitCount = characterMap.get('g');
            digitCount[8] = currDigitCount;
            characterMap.put('e',characterMap.get('e')-currDigitCount);
            characterMap.put('i',characterMap.get('i')-currDigitCount);
            characterMap.put('h',characterMap.get('h')-currDigitCount);
            characterMap.put('t',characterMap.get('t')-currDigitCount);
            characterMap.remove('g');
        }
        if(characterMap.getOrDefault('u',0)>0){
            currDigitCount = characterMap.get('u');
            digitCount[4] = currDigitCount;
            characterMap.put('f',characterMap.get('f')-currDigitCount);
            characterMap.put('o',characterMap.get('o')-currDigitCount);
            characterMap.put('r',characterMap.get('r')-currDigitCount);
            characterMap.remove('u');
        }
        if(characterMap.getOrDefault('h',0)>0){
            currDigitCount = characterMap.get('h');
            digitCount[3] = currDigitCount;
            characterMap.put('t',characterMap.get('t')-currDigitCount);
            characterMap.put('r',characterMap.get('r')-currDigitCount);
            characterMap.put('e',characterMap.get('e')-currDigitCount);
            characterMap.put('e',characterMap.get('e')-currDigitCount);
            characterMap.remove('h');
        }
        if(characterMap.getOrDefault('o',0)>0){
            currDigitCount = characterMap.get('o');
            digitCount[1] = currDigitCount;
            characterMap.put('n',characterMap.get('n')-currDigitCount);
            characterMap.put('e',characterMap.get('e')-currDigitCount);
            characterMap.remove('o');
        }
        if(characterMap.getOrDefault('f',0)>0){
            currDigitCount = characterMap.get('f');
            digitCount[5] = currDigitCount;
            characterMap.put('i',characterMap.get('i')-currDigitCount);
            characterMap.put('e',characterMap.get('e')-currDigitCount);
            characterMap.put('v',characterMap.get('v')-currDigitCount);
            characterMap.remove('f');
        }
        if(characterMap.getOrDefault('v',0)>0){
            currDigitCount = characterMap.get('v');
            digitCount[7] = currDigitCount;
            characterMap.put('s',characterMap.get('s')-currDigitCount);
            characterMap.put('e',characterMap.get('e')-currDigitCount);
            characterMap.put('e',characterMap.get('e')-currDigitCount);
            characterMap.put('n',characterMap.get('n')-currDigitCount);
            characterMap.remove('v');
        }
        if(characterMap.getOrDefault('i',0)>0){
            currDigitCount = characterMap.get('i');
            digitCount[9] = currDigitCount;
            characterMap.put('n',characterMap.get('n')-currDigitCount);
            characterMap.put('i',characterMap.get('i')-currDigitCount);
            characterMap.put('n',characterMap.get('n')-currDigitCount);
            characterMap.put('e',characterMap.get('e')-currDigitCount);
            characterMap.remove('i');
        }

        for (int i = 0; i < 10; i++) {
            while (digitCount[i]-->0)
                result+=i;
        }
        return result;
    }

    public String originalDigits(String s)
    {
        int[] count = new int[10];
        String res="";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='z') count[0]++;
            if(c=='w') count[2]++;
            if(c=='u') count[4]++;
            if(c=='x') count[6]++;
            if(c=='g') count[8]++;
            if(c=='h') count[3]++; //3-8
            if(c=='f') count[5]++; //5-4
            if(c=='s') count[7]++; //7-6
            if(c=='i') count[9]++; //9-8-6-5
            if(c=='o') count[1]++; //1-0-2-4
        }
        count[7]-=count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        count[3] -= count[8];
        count[5] -= count[4];
        count[9] = count[9]-count[8]-count[6]-count[5];
        for (int i = 0; i < 10; i++) {
            while (count[i]-->0)
                res+=i;
        }
        return res;
    }

    public void testGetDigits()
    {
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
        System.out.println(originalDigits("egith"));
    }
}
