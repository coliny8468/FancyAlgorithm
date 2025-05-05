// https://www.acmicpc.net/problem/6825
// 6825: Body Mass Index

import java.io.IOException;
import java.util.Scanner;

public class BOJ_6825 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        double height = sc.nextDouble();
        double bmi = weight / (height * height);
        if (bmi > 25) {
            System.out.println("Overweight");
        } else if (bmi >= 18.5) {
            System.out.println("Normal weight");
        } else {
            System.out.println("Underweight");
        }
    }
}
