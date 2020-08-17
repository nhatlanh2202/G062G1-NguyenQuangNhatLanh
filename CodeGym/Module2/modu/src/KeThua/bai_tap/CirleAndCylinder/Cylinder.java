package KeThua.bai_tap.CirleAndCylinder;


public class Cylinder extends Circle {
    public double height = 1.0;

    public Cylinder(double radius){
        super(radius);
    }

    public Cylinder(double radius,String color, double height){
        super(radius,color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return (Math.PI * (this.getRadius() * this.getRadius()) * this.height);
    }
    public String toString(){
        return " Hình trụ có chiều cao = "
                + getHeight()
                +" và có thể tích = "
                + getVolume();
    }
}

