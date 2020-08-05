package IntroductiontoJava.bai_tap;


import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args   ){
        double vnd = 23000;
        double usd ;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền USD cần đổi");
        usd = scanner.nextDouble();
        double doi = usd * 23000;
        System.out.print("Giá trị VNĐ" + doi);

    }
}
