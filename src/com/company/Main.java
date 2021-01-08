package com.company;

import com.company.entities.Triangle;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = input();
        printResults(triangle);
    }

    public static void printResults(Triangle triangle){
        System.out.println(triangle.getArea());
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.printTriangle());
        System.out.printf("%b %s", triangle.getColor(), triangle.isFilled());

    }

    public static Triangle input() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                double s1 = in.nextDouble();
                double s2 = in.nextDouble();
                double s3 = in.nextDouble();
                if(!checkIfValid(s1, s2, s3)){
                    throw new IllegalArgumentException("Sides are impossible!!!");
                }
                String c = in.next();
                boolean f = in.nextBoolean();
                return new Triangle(c, f, s1, s2, s3);
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Incorrect input!!!");
                in.nextLine();
            } catch (IllegalArgumentException illegalArgumentException){
                System.out.println(illegalArgumentException.getMessage());
                in.nextLine();
            }
        }
    }

    public static boolean checkIfValid(double a, double b, double c){
        double s = a + b + c;
        double m1 = Math.min(a, Math.min(b, c));
        double m3 = Math.max(a, Math.max(b, c));
        double m2 = s - m1 - m3;
        return !(m1 + m2 <= m3);
    }
}
