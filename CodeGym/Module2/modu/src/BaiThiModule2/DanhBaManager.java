package BaiThiModule2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhBaManager {
    public static Scanner scanner = new Scanner(System.in);
    public static List<DanhBa> list = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int choose;
        do {
            System.out.println("====Menu====\n" +
                    "1. Xem danh sach\n" +
                    "2. Them moi\n" +
                    "3. Cap nhat\n" +
                    "4. Xoa\n" +
                    "5. Tim kiem\n" +
                    "6. Doc tu file\n" +
                    "7. Ghi vao file\n" +
                    "8. Thoat");
            System.out.print("Chon chuc nang: ");
            String choose1 = scanner.nextLine();
            if (Validate.kiemTraSoNguyen(choose1)){
                choose = Integer.parseInt(choose1);
                switch (choose){
                    case 1:
                        hienThi();
                        break;
                    case 2:
                        them();
                        break;
                    case 3:
                        capNhat();
                        break;
                    case 4:
                        xoa();
                        break;
                    case 5:
                        timKiem();
                        break;
                    case 6:
                        docTuFile();
                        break;
                    case 7:
                        ghiVaoFile();
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("Lua chon khong co trong danh ba!");
                }
            }else
                System.out.println("Lua chon khong hop le!");
        }while (true);
    }

    private static void ghiVaoFile() {
        if (list.isEmpty()) System.out.println("DB trong !");
        System.out.println("Ban co thuc su muon cap nhat file hay k ?! Neu cap nhat toan bo noi dung file se bi xoa !\n" +
                "Nhap Yes neu muon cap nhat ! Neu khong nhap Yes thi lenh cap nhat se đuoc huy !");
        if (scanner.nextLine().equals("Yes")) {
            DanhBaDao.write(list);
            System.out.println("Cap nhat thanh cong !");
        } else System.out.println("Lenh cap nhat đa đuoc huy !\n");
    }

    private static void docTuFile() {
        if (DanhBaDao.read().isEmpty()) System.out.println("File trong !");
        System.out.println("Ban co thuc su muon cap nhat DB hay k ?! Neu cap nhat toan bo bo nho DB sẽ bi xoa !\n" +
                "Nhap Yes neu muon cap nhat ! Neu khong nhap Yes thi lenh cap nhat se đuoc huy !");
        if (scanner.nextLine().equals("Yes")) {
            list = DanhBaDao.read();
            System.out.println("Cap nhat thanh cong !");
            hienThi();
        } else System.out.println("Lenh cap nhat đa đuoc huy !\n");
    }

    private static void timKiem() {
        if (list.isEmpty()) System.out.println("Trong !\n");
        else {
            boolean kiemTra = true;
            int bienDem = 1;
            System.out.print("Nhap thong tin can tim : ");
            String nhap = scanner.nextLine();
            for (DanhBa doiTuong : list) {
                if (doiTuong.getSdt().contains(nhap) || doiTuong.getTen().contains(nhap)) {
                    kiemTra = false;
                    if (bienDem == 1) System.out.println("DB khop voi thong tin can tim la:");
                    System.out.println(bienDem + ". " + doiTuong.thongTin());
                    bienDem++;
                }
            }
            if (kiemTra) System.out.println("Không tìm thấy DB khớp với thông tin bạn nhập !\n");
        }
    }

    private static void xoa() {
        if (list.isEmpty())
            System.out.println("trong");
        else {
            DanhBa danhBa = null;
            do {
                System.out.print("Nhap sdt can xoa: ");
                String sdt = scanner.nextLine();
                if (sdt.equals("")){
                    System.out.println("khong nhap thi khong xoa");
                    break;
                }
                for (DanhBa element : list){
                    if (sdt.equals(element.getSdt())){
                        danhBa = element;
                        break;
                    }
                }
                if (danhBa != null)
                    break;
                else
                    System.out.println("khong tim thay");
            }while (true);
            if (danhBa != null){
                System.out.println("ban co muon xoa? Muon thi nhan Y va neu nhap khac Y thi huy lenh xoa");
                if (scanner.nextLine().equals("Y")){
                    list.remove(danhBa);
                    System.out.println("xoa thanh cong!");
                }else System.out.println("Lenh xoa da duoc huy");
            }
        }
    }

    private static void capNhat() {
        if (list.isEmpty())
            System.out.println("Trong");
        else {
            DanhBa danhBa = null;
            do {
                System.out.print("Nhap sdt can sua: ");
                String sdt = scanner.nextLine();
                if (sdt.equals("")){
                    System.out.println("Khong nhap khong sua");
                    break;
                }
                for (DanhBa element : list){
                    if (sdt.equals(element.getSdt())){
                        danhBa = element;
                        break;
                    }
                }
                if (danhBa != null)
                    break;
                else
                    System.out.println("Khong tim thay! Nhap lai: ");
            }while (true);
            if (danhBa != null){
                String nhom = Validate.kiemTraNhapChu("Nhom danh ba");
                danhBa.setNhom(nhom);
                String ten = Validate.kiemTraNhapChu("Ho va ten");
                danhBa.setTen(ten);
                String gioiTinh = Validate.kiemTraNhapChu("Gioi tinh");
                danhBa.setGioiTinh(gioiTinh);
                String diaChi = Validate.kiemTraNhapChu("Dia chi");
                danhBa.setDiaChi(diaChi);
                String ngaySinh = Validate.kiemTraNhapChu("Ngay sinh");
                danhBa.setNgaySinh(ngaySinh);
                String email = Validate.kiemTraEmail();
                danhBa.setEmail(email);
                System.out.println("Cap nhat thanh cong!");
            }
        }
    }

    private static void them() {
        String sdt = Validate.kiemTraSDT();
        String nhom = Validate.kiemTraNhapChu("Nhom danh ba");
        String ten = Validate.kiemTraNhapChu("Ho va ten");
        String gioiTinh = Validate.kiemTraNhapChu("Gioi tinh");
        String diaChi = Validate.kiemTraNhapChu("Dia chi");
        String ngaySinh = Validate.kiemTraNhapChu("Ngay sinh");
        String email = Validate.kiemTraEmail();
        DanhBa danhBa = new DanhBa(sdt,nhom,ten,gioiTinh,diaChi,ngaySinh,email);
        list.add(danhBa);
        System.out.println("Them thanh cong!");
    }

    public static void hienThi() {
        if (list.isEmpty())
            System.out.println("Trong!");
        else {
            int bienDem = 0;
            for (DanhBa danhBa : list) {
                if (bienDem % 5 == 0) {
                    System.out.println("Ban co muon them! Y neu co neu khong thi Enter de tiep tuc");
                    String nhap = scanner.nextLine();
                    if (nhap.equals("Y")) {
                        them();
                        break;
                    } else if (!nhap.equals("")) {
                        System.out.println("Khong hop le");
                    }
                }
                System.out.println((bienDem + 1) + ". " + danhBa.thongTin());
                bienDem++;
            }
        }
    }
}
