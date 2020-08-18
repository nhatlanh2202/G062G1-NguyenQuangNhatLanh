package DSAStackVaQueue.bai_tap.KiemTraDauNgoac;

import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        String expression = "s * ((s - a) * (s - b)) * (s - c)";
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '('){
                stack.push(i);
            }else if(expression.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else {
                    stack.push(i);
                }
            }
        }
        if(stack.empty()){
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }
    }
}
