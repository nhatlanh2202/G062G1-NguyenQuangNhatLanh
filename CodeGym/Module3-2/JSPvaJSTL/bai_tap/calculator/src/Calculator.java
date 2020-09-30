public class Calculator {
    public static float calculator(float first, String operator, float second){
        float result = 0;

        if (operator.equals("+")){
            result = first + second;
        }else if (operator.equals("-")){
            result = first - second;
        }else if (operator.equals("x")){
            result = first * second;
        }else {
            try {
                result = first / second;
                if (second ==0){
                    throw new  ArithmeticException() ;
                }
            }catch (ArithmeticException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
