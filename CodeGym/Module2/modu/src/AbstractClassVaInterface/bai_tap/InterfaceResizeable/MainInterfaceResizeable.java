package AbstractClassVaInterface.bai_tap.InterfaceResizeable;

public class MainInterfaceResizeable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3, "yellow", false);
        shapes[1] = new Rectangle(2, 4, "infinity", true);
        shapes[2] = new Square(5, "melinda", true);
        for (Shape a : shapes){
            System.out.println(a);
        }
        System.out.print("Sau khi thay đổi kích thước: ");
        for (Shape a : shapes) {
            a.resize(Math.random() * 100);
        }
        System.out.println("\n");
        Shape.printShape(shapes);

    }

}

