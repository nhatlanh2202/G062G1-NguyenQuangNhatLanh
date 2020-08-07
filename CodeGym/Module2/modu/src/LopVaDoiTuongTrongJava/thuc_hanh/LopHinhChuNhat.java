package LopVaDoiTuongTrongJava.thuc_hanh;

import java.util.Scanner;

public class LopHinhChuNhat {
    double width, height;

    public LopHinhChuNhat() {
    }

    public LopHinhChuNhat(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "hình chữ nhật có: {" + "chiều rộng = " + width + ", chiều cao = " + height + "}";
    }
}
class Ex14_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều rộng: ");
        double width = scanner.nextDouble();
        System.out.print("Nhập chiều cao: ");
        double height = scanner.nextDouble();
        LopHinhChuNhat rectangle = new LopHinhChuNhat(width, height);
        System.out.println(rectangle.display());
        System.out.println("Chu vi của hình chữ nhật: "+ rectangle.getPerimeter());
        System.out.println("Diện tích hình chữ nhật: "+ rectangle.getArea());
    }
}

