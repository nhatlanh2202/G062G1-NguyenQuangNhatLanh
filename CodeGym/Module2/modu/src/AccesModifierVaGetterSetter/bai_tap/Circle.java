package AccesModifierVaGetterSetter.bai_tap;

import java.util.Scanner;

public class Circle {
    private double radius;
    private String color = "red" ;

    public Circle(double radius) {
        this.radius = radius;

    }

    public Circle(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return ((this.radius * this.radius) * Math.PI);
    }
}
class TestCircle{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập bán kính: ");
        double radius = scanner.nextDouble();
        Circle testCircle = new Circle(radius);
        System.out.println("Diện tích hình tròn: " + testCircle.getArea()
                                    + "\nvà màu là: " + testCircle.getColor());
    }
}
