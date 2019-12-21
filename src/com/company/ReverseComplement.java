package com.company;

public class ReverseComplement {
    public static void main(String[] args) {
        long startTime, stopTime;

        startTime = System.currentTimeMillis();
        System.out.println(getReverseComplement("TTGTGTC"));
        stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);

        startTime = System.currentTimeMillis();
        System.out.println(getReverseComplementVersion2("TTGTGTC"));
        stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);

    }
    private static String getReverseComplement(String pattern){
        StringBuilder reverse;
        char aux;
        int n = pattern.length();
        reverse = new StringBuilder();

        for (int i=0; i< n; i++){
            aux = pattern.charAt(i);
            switch (aux){
                case 'A': reverse.insert(0, 'T'); break;
                case 'T': reverse.insert(0, 'A'); break;
                case 'G': reverse.insert(0, 'C'); break;
                case 'C': reverse.insert(0, 'G'); break;
            }
        }
        return reverse.toString();
    }
    private static String getReverseComplementVersion2(String pattern){
        return new StringBuilder(pattern.replace('A','X')
                      .replace('G','Y')
                      .replace('C','G')
                      .replace('T','A')
                      .replace('Y','C')
                      .replace('X','T')).reverse().toString();
    }

}
