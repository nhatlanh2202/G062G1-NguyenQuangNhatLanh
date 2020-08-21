package ThuatToanTimKiem.bai_tap.TimKiemSuDungDeQuy;

public class BinarySearch {

    public static int binarySearch(int[] array, int key){
        int low = 0;
        int high = array.length - 1;
        int mid;
        while(high >= low){
            mid = (high + low) / 2;
            if(key == array[mid]){
                return mid;
            }else if(key > array[mid]){
                 low =  mid + 1;
            }else {
                 high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
     int[] array = {1,2,3,4,5,6,7,8,9};
     int value = BinarySearch.binarySearch(array,9);
     System.out.println("Số cần tìm nằm ở vị trí số: " + value);
    }
}
