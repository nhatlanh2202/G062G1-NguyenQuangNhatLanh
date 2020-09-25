public class Calculator {
    public static float calculator(float first, String operator, float second){
        float result = 0;

        if (operator.equals("+")){
            result = first + second;
        }else if (operator.equals("-")){
            result = first - second;
        }else if (operator.equals("x")){
            result = first * second;
        }else{
            result = first / second;
        }
        return result;
    }
}
