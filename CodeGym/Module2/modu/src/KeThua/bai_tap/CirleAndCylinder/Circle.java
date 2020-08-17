package KeThua.bai_tap.CirleAndCylinder;


public class Circle {
    private double radius = 1.0;
    private String color = " red";

    public Circle(){
    }

    public Circle(double radius){

    }

    public Circle(double radius, String color){
        this.radius = radius;
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
        return ((this.radius * this.radius)* Math.PI);
    }

    public double getPerimeter(){
        return (2 * this.radius * Math.PI);
    }
    public String toString(){
        return " Hình tròn có bán kính là= "
                + getRadius()
                + " và có màu là: "
                + getColor();
    }
}