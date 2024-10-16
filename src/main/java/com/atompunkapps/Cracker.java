package com.atompunkapps;

import org.apache.pdfbox.Loader;

import java.io.File;
import java.io.IOException;

public class Cracker {
    public static void main(String[] args) {
        File file = new File("pdf/4024574.pdf");

        for(int i = 0; i < 10000; i++) {
            try {
                String pwd = pad(i);
//                PDDocument pdf = Loader.loadPDF(file, pwd);
                Loader.loadPDF(file, pwd);
                System.out.println(pwd);
                break;
            }
            catch(IOException ignored) {}
        }
    }

//    private static String pad(int number, int pwdLength) { // Mine was 4 digits, so I hardcoded
    private static String pad(int number) {
        StringBuilder builder = new StringBuilder(String.valueOf(number));
        for(int i = 4 - builder.length(); i > 0; i--) {
            builder.insert(0, "0");
        }
        return builder.toString();
    }
}
