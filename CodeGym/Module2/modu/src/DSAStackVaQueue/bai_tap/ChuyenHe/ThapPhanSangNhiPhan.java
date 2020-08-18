package DSAStackVaQueue.bai_tap.ChuyenHe;

import java.util.Scanner;
import java.util.Stack;

public class ThapPhanSangNhiPhan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Nhập số thập phân: ");
        int num = in.nextInt();
        while (num != 0){
            int d = num % 2;
            stack.push(d);
            num = num / 2;
        }
        System.out.print("Giá trị nhị phân là: ");
        while (!(stack.isEmpty())){
            System.out.print(stack.pop());
        }
    }
}
