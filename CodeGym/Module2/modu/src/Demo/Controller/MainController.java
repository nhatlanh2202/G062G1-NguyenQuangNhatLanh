package Demo.Controller;

import Demo.Views.ChucNang;

import java.util.Scanner;


public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int chon;
        do {
            System.out.println("1. Thêm mới\n" +
                    "2. Xóa\n" +
                    "3. Xem danh sách các sản phẩm\n" +
                    "4. Tìm kiếm\n" +
                    "5. Thoát\n");
            System.out.print("Chon chuc nang: ");
            String luaChon = scanner.nextLine();
            switch (luaChon){
                case "1":
                    ChucNang.themMoi();
                    break;
                case "2":
                    ChucNang.xoa();
                    break;
                case "3":
                    ChucNang.xemDanhSach();
                    break;
                case "4":
                    ChucNang.timKiem();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong co");
            }
        }while (true);
    }
}
