package ThuatToanTimKiem.thuc_hanh.TimKiemKhongSuDungDeQuy;

public class BinarySearch {
    static int[] list = {2,4,7,10,11,45, 50, 59, 60, 66, 69, 70, 79};

    static int binarySearch(int[] list, int key){
        int low = 0;
        int hight = list.length - 1;
        while (hight >= low){
            int mid = (low + hight) / 2;
            if (key < list[mid])
                hight = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list,2));
        System.out.println(binarySearch(list,11));
        System.out.println(binarySearch(list,54));
        System.out.println(binarySearch(list,50));
        System.out.println(binarySearch(list,66));
        System.out.println(binarySearch(list,66));
    }
}
