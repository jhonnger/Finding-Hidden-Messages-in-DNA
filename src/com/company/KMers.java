package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KMers {
    public static void main(String[] args) {

        System.out.println("" + FrequentWords("CGGAGGACTCTAGGTAACGCTTATCAGGTCCATAGGACATTCA",3));
    }
    public static ArrayList<String> FrequentWords(String text, int k) {
        Map<String, Integer> patterns;
        ArrayList<String> result;
        int max;
        String aux;

        patterns = new HashMap<>();
        result = new ArrayList<>();
        for(int i = 0; i< text.length() -k +1; i++){
            aux = text.substring(i, i +k);
            if(!patterns.containsKey(aux)){
                patterns.put(aux, kmers(text,aux));
            }
        }
        max = 0;
        for (Map.Entry<String, Integer> entry : patterns.entrySet()) {
            if(entry.getValue() > max){
                max = entry.getValue();
                result.clear();
            }
            if(entry.getValue() == max){
                result.add(0,entry.getKey());
            }
        }

        return result;

    }

    private static int kmers(String text, String pattern){
        int count = 0;
        int position = 0;
        while( (position = text.indexOf(pattern,position)+1) != 0 ) count++;

        return count;
    }

}
