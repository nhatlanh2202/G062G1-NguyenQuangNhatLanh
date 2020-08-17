package KeThua.bai_tap.PointAndMoveablePointAssignment;

public class Point {
    float x = 0.0f;
    public float y = 0.0f;

    public Point(){

    }

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY(){
        float[] arr = new float[2];
        return arr;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "("
                + getX()
                + ", "
                + getY()
                + ")";
    }
}
