package KeThua.bai_tap.PointAndMoveablePointAssignment;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3,4);
        System.out.println(point);


        MovablePoint movablePoint = new MovablePoint(3,4,1,2);
        System.out.println(movablePoint);
        movablePoint.move();
        System.out.println(movablePoint);
    }
}
