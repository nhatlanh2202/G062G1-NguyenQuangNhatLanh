package DSAStackVaQueue.bai_tap.StackDaoNguocMang;

import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> number = new Stack<>();
        number.push(5);
        number.push(4);
        number.push(3);
        number.push(2);
        number.push(1);
        System.out.println("Mảng ban đầu là: " + number);
        for (Integer elements : number){
            System.out.println(elements);
        }
        System.out.println("Mảng sau khi đảo là: ");
        while(!number.isEmpty()){
            System.out.println(number.pop());
        }



        Stack<String> wStack = new Stack<>();
        String string = "Tôi là một thằng ngốc";
        System.out.println("Chuỗi ban đầu: " + string);

        String[] mWord = string.split("\\s");
        for(String word : mWord){
            wStack.push(word);
        }
        System.out.println("Chuỗi sau khi đảo là: ");
        for(int i = 0; i < mWord.length; i++){
            System.out.println(wStack.pop() + " ");
        }

    }
}
