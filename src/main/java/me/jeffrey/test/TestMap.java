package me.jeffrey.test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestMap {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> testMap = new HashMap<String, ArrayList<Integer>>();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.add("1");
        keyList.add("2");
        keyList.add("3");
        for(int i=0; i < 10; i++){
            for (String key:
                 keyList) {
                ArrayList<Integer> tempList = testMap.get(key);
                if(tempList != null){
                    tempList.add(i);
                }else {
                    tempList = new ArrayList<Integer>();
                    tempList.add(i);
                    testMap.put(key, tempList);
                }
            }
        }
        System.out.println(testMap);
    }
}
