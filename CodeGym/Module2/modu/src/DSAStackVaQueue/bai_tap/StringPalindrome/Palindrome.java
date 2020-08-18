package DSAStackVaQueue.bai_tap.StringPalindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Nhập vào chuỗi cần kiểm tra: ");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        Queue queue = new LinkedList();
        for(int i = inputString.length() - 1; i >= 0; i--){
            queue.add(inputString.charAt(i));
        }
        String reverseString = "";
        while(!queue.isEmpty()){
            reverseString = reverseString + queue.remove();
        }
        if(inputString.equals(reverseString)){
            System.out.println("Chuỗi " + inputString + " là một palindrome ");
        }else {
            System.out.println("Chuỗi " + inputString + " không phải là palindrome ");
        }
    }
}
