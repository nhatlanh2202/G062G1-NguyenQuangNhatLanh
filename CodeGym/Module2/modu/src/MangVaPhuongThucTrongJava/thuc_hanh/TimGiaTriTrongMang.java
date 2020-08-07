package MangVaPhuongThucTrongJava.thuc_hanh;


import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args){
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya",
                            "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên học sinh: ");
        String input_name = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Vị trí của các sinh viên trong danh sách " + input_name + " is: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (!isExist)
            System.out.println("Không tìm thấy tên học sinh: " + input_name + " trong danh sách.");
    }
}
