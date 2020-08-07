package MangVaPhuongThucTrongJava.bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[] myArr = {10,4,6,7,8,6,0,0,0};
        int[] newArr = addArr(myArr);
        for (int i=0; i< newArr.length; i++) {
            System.out.print(newArr[i]+ " ");
        }
    }
    public static int[] addArr(int[]myArray){
        int[]newArr = new int[myArray.length];
        for(int i=0; i< myArray.length; i++){
            newArr[i] = myArray[i];
        }
        return newArr;
    }
}
