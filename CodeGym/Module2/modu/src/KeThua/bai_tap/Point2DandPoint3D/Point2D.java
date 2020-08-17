package KeThua.bai_tap.Point2DandPoint3D;

public class Point2D {
    float x = 0.0f;
    float y = 0.0f;

    public Point2D(float x, float y){

    }

    public Point2D(){

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
        float[] arrayOf = new float[]{x, y};
        return arrayOf;
    }
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(x, y)";
    }
}
