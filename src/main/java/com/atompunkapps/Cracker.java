package com.atompunkapps;

import org.apache.pdfbox.Loader;

import java.io.File;
import java.io.IOException;

public class Cracker {
    public static void main(String[] args) {
        File file = new File("pdf/4024574.pdf");
        System.out.println(crack(file, 4));
    }

    private static String crack(File file, int pwdLength) {
//        for(int i = 0; i < 10000; i++) {
        for(int i = 0; i < (int) Math.pow(10, pwdLength); i++) {
            try {
//                String pwd = pad(i);
                String pwd = pad(i, pwdLength);
                Loader.loadPDF(file, pwd);
//                System.out.println(pwd);
                return pwd;
            }
            catch(IOException ignored) {}
        }

        return null;
    }

//    private static String pad(int number) {
    private static String pad(int number, int pwdLength) {
        StringBuilder builder = new StringBuilder(String.valueOf(number));
        for(int i = pwdLength - builder.length(); i > 0; i--) {
            builder.insert(0, "0");
        }
        return builder.toString();
    }
}
