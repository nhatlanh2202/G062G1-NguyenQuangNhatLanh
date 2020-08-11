package AbstractClassVaInterface.thuc_hanh.InterfaceComparable.thuc_hanh;

public class TestCirle {
    public static void main(String[] args) {
        Circle circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);
    }
}
