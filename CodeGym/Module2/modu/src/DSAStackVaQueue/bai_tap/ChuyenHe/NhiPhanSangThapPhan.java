package DSAStackVaQueue.bai_tap.ChuyenHe;

public class NhiPhanSangThapPhan {
    public int BinaryToDecimal(int binaryNumber){
        int decimal = 0;
        int p = 0;
        while(true){
            if(binaryNumber == 0){
                break;
            } else {
                int temp = binaryNumber%10;
                decimal += temp*Math.pow(2, p);
                binaryNumber = binaryNumber/10;
                p++;
            }
        }
        return decimal;
    }
    public static void main(String[] args) {
        NhiPhanSangThapPhan obj = new NhiPhanSangThapPhan();
        System.out.println(obj.BinaryToDecimal(110));
        System.out.println(obj.BinaryToDecimal(1000010));
        System.out.println(obj.BinaryToDecimal(1010011010));
    }
}
