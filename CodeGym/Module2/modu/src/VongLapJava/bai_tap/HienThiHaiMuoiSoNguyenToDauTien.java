package VongLapJava.bai_tap;

public class HienThiHaiMuoiSoNguyenToDauTien {
    public static void main(String[] args){
        int count = 0;
        for(int i=2; ;i++){
            if(checkPrimeNumber(i)){
                System.out.print(i + " ");
                count++;
                if(count==20){
                    break;
                }
            }
        }
    }

    //Cách kiểm tra số nguyên tố
    public static boolean checkPrimeNumber(int num){
        if(num < 2){
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
