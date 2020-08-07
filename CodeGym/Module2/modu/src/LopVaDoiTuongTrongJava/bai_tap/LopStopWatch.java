package LopVaDoiTuongTrongJava.bai_tap;

import java.util.Arrays;

public class LopStopWatch {
    private long startTime;
    private long endTime;

    public LopStopWatch(){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public long getterStartTime(){
        return this.startTime;
    }
    public long getEndTime(){
        return this.endTime;
    }
    public void start(){
        this.startTime = System.currentTimeMillis();
    }
    public void stop(){
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return endTime - startTime;

    }
}
class MainWatch{
    public static void main(String[] args) {
        int[] array = new int[1000000];
        for(int i=0; i< array.length; i++){
            array[i] = (int)(Math.random()*1000000+1);
        }
        LopStopWatch stopWatch = new LopStopWatch();
        stopWatch.start();
        Arrays.sort(array);
        stopWatch.stop();
        System.out.println(stopWatch.getElapsedTime());
    }
}
