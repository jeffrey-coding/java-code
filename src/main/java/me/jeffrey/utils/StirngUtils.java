package me.jeffrey.utils;

public class StirngUtils {
    public static boolean isNumber(String str){
        boolean pointFlag = false;
        boolean markFlag = false;
        if(str.length() == 0)
            return false;
        else if(str.length() == 1 && (str.charAt(0) < 48 || str.charAt(0) > 57))
            return false;

        for(int i= str.length(); --i>=0;){
            int chr=str.charAt(i);
            if(chr >= 48 && chr <= 57)
                continue;
            else if(!markFlag && i==0 && (chr == 43 || chr == 45)){
                markFlag = true;
                continue;
            }else if(!pointFlag && chr == 46){
                pointFlag = true;
                continue;
            }
            return false;
        }
        return true;
    }
}
