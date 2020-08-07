package LopVaDoiTuongTrongJava.bai_tap;

public class LopFan {
    final int SlOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private int speed = SlOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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
    public String toString(){
        if(this.on){
            return this.speed + ", " + this.color + ", " + this.radius + ", fan is on";
        }else {
            return this.color + ", " + this.radius + ", fan is off";
        }
    }
}
class MainFan{
    public static void main(String[] args) {
        LopFan fan1 = new LopFan();
        LopFan fan2 = new LopFan();

        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setOn(true);

        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());

    }
}
