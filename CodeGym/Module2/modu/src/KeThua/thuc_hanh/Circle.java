package KeThua.thuc_hanh;

public class Circle extends Shape{
    public double radius = 1.0;

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double v, String indigo, boolean b) {
    }

    public Circle(String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return ((this.radius * this.radius)* Math.PI);
    }
    public double getPerimeter(){
        return (2 * this.radius * Math.PI);
    }
    public String toString(){
        return "Hình tròn có diện tích là = " + getArea()
                + " Chu vi hình tròn = " + getPerimeter();
    }
}

