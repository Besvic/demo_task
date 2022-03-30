package com.work.bvs.validate;

public class Valid {

    private static final String REGEX_CORRECT_NUMBER = "-?\\d+(\\.\\d+)?";

    public static boolean isNumber(String str){
        return str != null && !str.isEmpty() && str.matches(REGEX_CORRECT_NUMBER);
    }
}
