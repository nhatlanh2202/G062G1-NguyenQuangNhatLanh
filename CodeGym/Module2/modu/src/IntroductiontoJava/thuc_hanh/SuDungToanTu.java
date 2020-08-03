package IntroductiontoJava.thuc_hanh;

import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String[] argr){
        float wight;
        float height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter wight");
        wight = scanner.nextFloat();

        System.out.println("Enter height");
        height = scanner.nextFloat();

        float area = wight * height;

        System.out.println("Area is " + area);

    }

}
