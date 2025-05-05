package com;

import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        if (s1.length() - 1 >= s2.length() - 1) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
    }
}
