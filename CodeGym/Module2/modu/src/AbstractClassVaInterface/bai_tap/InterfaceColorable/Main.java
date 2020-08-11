package AbstractClassVaInterface.bai_tap.InterfaceColorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3,"blue",true);
        System.out.println(shapes[0]);
        shapes[1] = new Square(5,"blue",true);
        System.out.println(shapes[1]);
        for (Shape shape : shapes){
            if(shape instanceof Square){
                ((Square)shape).howtoColor();
                System.out.println(shape);
            }
        }
    }
}
