package VongLapJava.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args){
        int height ;
        Scanner sc = new Scanner(System.in);
        //Hình chữ nhật
        do {
            System.out.println("height = ");
            height = sc.nextInt();
        }while(height <= 0);
        for (int i = 0; i < height; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(" * ");
            }
            System.out.println("  ");
        }

        //Hình tam giác vuông, có cạnh góc vuông ở botton-left
        System.out.println("  ");
        for(int i=1; i<=5; i++){
            for(int j=1; j<i; j++){
                System.out.print(" * ");
            }
            System.out.println("  ");
        }

       //Hình tam giác vuông, có cạnh góc vuông ở top-left
        System.out.println("  ");
        for(int i=7;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(" * ");
            }
            System.out.println("  ");
        }

        //Hình tam giác cân

        for(int i=1; i<=height; i++ ){
            for(int j=1; j<=height-i; j++){
                System.out.print("  ");
            }
            for(int k=1; k <= 2*i-1; k++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
}

