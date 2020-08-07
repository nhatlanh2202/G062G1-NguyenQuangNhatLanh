package MangVaPhuongThucTrongJava.bai_tap;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args){
        int[] arr1 = new int[2];
        int[] arr2 = new int[2];
        int[] arr3 = new int[arr1.length + arr2.length];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá trị mảng thứ nhất: ");
        for(int i=0; i< arr1.length; i++){
            System.out.print("Nhập giá trị thứ " + (i+1) + " cho mảng 1: ");
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Nhập giá trị mảng thứ hai: ");
        for(int i=0; i< arr2.length; i++){
            System.out.print("Nhập giá trị thứ " + (i+1) + " cho mảng 2: ");
            arr2[i] = scanner.nextInt();
        }
        for(int i=0; i< arr1.length; i++){
            arr3[i] = arr1[i];
        }
        for (int i=0; i<arr2.length;i++){
            arr3[arr1.length+i] = arr2[i];
        }
        System.out.println("Giá trị của mảng đã gộp là: ");
        for(int i = 0 ; i< arr3.length; i++){
            System.out.print(arr3[i] + " \t");
        }
    }
}
