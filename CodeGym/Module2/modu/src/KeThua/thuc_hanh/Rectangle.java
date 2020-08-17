package KeThua.thuc_hanh;

public class Rectangle  extends Circle{
    public double width = 1.0;
    public double length = 1.0;

    public Rectangle() {
        super(3.5, "indigo", false);
    }

    public Rectangle(double width, double length) {
        super(3.5, "indigo", false);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + " and area= "
                + getArea()
                + " and perimeter= "
                + getPerimeter();
    }
}
