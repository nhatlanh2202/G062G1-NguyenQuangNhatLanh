package BaiThiModule2;

import java.util.Scanner;

public class Validate {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean kiemTraSoNguyen(String nhap){
        return nhap.matches("\\d+");
    }

    public static String kiemTraEmail(){
        String email;
        do {
            System.out.print("Nhap email: ");
            email = scanner.nextLine();
            if (email.matches("^[a-zA-Z][\\w]+@[a-z]+[\\.][a-z]+([\\.][a-z]+)*$"))
                break;
            else System.out.println("Email khong dung dinh dang");
        }while (true);
        return email;
    }

    public static String kiemTraSDT(){
        String sdt;
        do {
            System.out.print("Nhap sdt: ");
            sdt = scanner.nextLine();
            if (sdt.matches("^\\d{10}$"))break;
            else
                System.out.println("Sdt khong dung dinh dang");
        }while (true);
        return sdt;
    }

    public static String kiemTraNhapChu(String thongTin){
        String nhapThongTin;
        do {
            System.out.print("Nhap " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (nhapThongTin.equals(""))
                System.out.println("Muc nay khong duoc de trong");
            else
                break;
        }
        while (true);
        return nhapThongTin;
    }
}
