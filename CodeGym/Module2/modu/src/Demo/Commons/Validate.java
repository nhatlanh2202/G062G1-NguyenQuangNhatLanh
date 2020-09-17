package Demo.Commons;

import java.util.Scanner;

public class Validate {
    public static Scanner scanner = new Scanner(System.in);


    public static boolean kiemTraNhapSoNguyen(String nhap){
        return nhap.matches("^\\d+");
    }

    public static boolean kiemTraNhapSoThuc(String nhap){
        return nhap.matches("\\d+(\\.\\d+)?");
    }


    public static String kiemTraNhapSo(String thongTin){
        String nhapThongTin;
        do {
            System.out.print("Nhap " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (kiemTraNhapSoThuc(nhapThongTin) && Float.parseFloat(nhapThongTin) > 0)
                break;
            else System.out.println("Thong tin k hop le!");
        }while (true);
        return nhapThongTin;
    }
    public static String kiemTraNhapChu(String thongTin){
        String nhapThongTin;
        do {
            System.out.print("Nhap " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (nhapThongTin.equals(""))
                System.out.println("thong tin khong duoc bo trong");
            else
                break;
        }while (true);
        return nhapThongTin;
    }
}
