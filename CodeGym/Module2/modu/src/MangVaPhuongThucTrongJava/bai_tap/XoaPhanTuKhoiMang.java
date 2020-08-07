package MangVaPhuongThucTrongJava.bai_tap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
            int[] myArr = new int[]{10,4,6,7,8,6,0,0,0};
        for (int a: myArr) {
            System.out.print(a + "\t");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá trị cần xoá: ");
        int del = scanner.nextInt();

        //Tìm giá trị đã nhập có tồn tại trong mảng hay không:
        int index = -1;
        for (int i = 0; i < myArr.length; i++){
            if (myArr[i]==del){
                index = i;
                System.out.println("Giá trị bạn muốn xoá nằm ở vị trí thứ: " + (i+1));
            }
        }

        if (index == -1){
            System.out.println("Trong mảng không có phần tử nào có giá trị là: " + del);
        }else {
            for (int i = index; i < myArr.length-1; i++){
                myArr[i] = myArr[i+1];
            }
            myArr[myArr.length-1] = 0;
        }

        for (int a: myArr) {
            System.out.print(a + " ");
        }
    }
}
