package BTNew;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        DanhBaManager danhBaManager = new DanhBaManager();
        int danhBaId;
        String ten;

        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    danhBaManager.add();
                    break;
                case "2":
                    danhBaId = danhBaManager.inputId();
                    danhBaManager.edit(danhBaId);
                    break;
                case "3":
                    danhBaId = danhBaManager.inputId();
                    danhBaManager.delete(danhBaId);
                    break;

                case "4":
                    danhBaManager.show();
                    break;
                case "5":
                    ten = danhBaManager.inputHoTen();
                    DanhBa danhBa = danhBaManager.timkiemTD(ten);
                    if (danhBa == null){
                        System.out.println("không có danh bạ");
                    }else {
                        System.out.println(danhBa);
                    }
                    break;
                case "0":
                    System.out.println("thoát!");
                    exit = true;
                    break;
                default:
                    System.out.println("không hợp lệ! vui lòng chọn hành động trong menu dưới đây:");
                    break;
            }
            if (exit) {
                break;
            }
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("-----CHƯƠNG TRÌNH QLY DANH BẠ------");
        System.out.println("1. Add danh bạ.");
        System.out.println("2. Edit danh bạ theo id.");
        System.out.println("3. Delete danh bạ theo id.");
        System.out.println("4. Show danh bạ.");
        System.out.println("5. tìm kiếm.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Chọn chức năng: ");
    }
}
