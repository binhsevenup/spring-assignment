package com.demo.utils;

public class Utils {
    public static int convertToInt(String input, int defaultValue) {
        int output = defaultValue;
        try {
            output = Integer.parseInt(input);
        }catch (Exception e) {

        }
        return output;
    }
}
