package VongLapJava.bai_tap;

public class HienThiSoNguyenToNho100 {
    public static void main(String[] args){
        for(int i=2; i<100; i++){
            if(checkPrimeNumber(i)){
                System.out.print(i + " ");
            }
        }
    }

    //Kiểm tra số nguyên tố
    public static boolean checkPrimeNumber(int num){
        if (num < 2){
            return false;
        }else if(num == 2){
            return true;
        }else {
            for(int i=2; i<=Math.sqrt(num); i++){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
}
