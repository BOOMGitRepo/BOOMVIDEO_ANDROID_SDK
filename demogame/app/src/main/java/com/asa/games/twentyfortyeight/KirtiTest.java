package com.asa.games.twentyfortyeight;

/**
 * Created by jesnia on 13/8/15.
 */


public class KirtiTest {
    public static void main(String[] args) {

        String str = "jesni abraham jesni";
        char[] charArray = str.toCharArray();
        char[] charString = new char[19];
        int[] charIndex = new int[19];
        for (int i = 0; i < charArray.length; i++) {
            int flag = 0;
            for (int j = 0; j < charString.length; j++) {
                System.out.println("string "+charString[j]+"  array charecter "+charArray[i]);
                if (charString[j] == charArray[i]) {
                    flag = 1;
                    charIndex[j] = charIndex[j] + 1;
                }
            }
            if (flag == 0) {

                charString[i] = charArray[i];
                charIndex[i] = charIndex[i] + 1;
            }
        }

    }
}