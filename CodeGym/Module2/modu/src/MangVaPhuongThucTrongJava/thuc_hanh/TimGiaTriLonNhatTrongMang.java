package MangVaPhuongThucTrongJava.thuc_hanh;


import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args){
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập độ dài của mảng: ");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Độ dài của mảng không quá 20 ký tự");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập phân tử của mảng " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("danh sách các phần tử: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng là: " + max + " ,tại vị trí " + index);
    }
}
