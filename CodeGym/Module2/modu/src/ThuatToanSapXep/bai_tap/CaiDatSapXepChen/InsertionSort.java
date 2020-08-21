package ThuatToanSapXep.bai_tap.CaiDatSapXepChen;

public class InsertionSort {

    public void insertionSort(int arr[]) {
        int valueToInsert;
        int holePosition;
        int i;
        for (i = 1; i < arr.length; i++) {

            // Chọn một giá trị để chèn
            valueToInsert = arr[i];

            // Lựa chọn vị trí cần chèn
            holePosition = i;

            // Kiểm tra số liền trước có lớn hơn giá trị được chèn không
            while (holePosition > 0 && arr[holePosition - 1] > valueToInsert) {
                arr[holePosition] = arr[holePosition - 1];
                holePosition--;
                System.out.println("Di chuyển phần tử: " + arr[holePosition]);
            }

            if (holePosition != i) {
                System.out.println("Chèn phần tử: " + valueToInsert
                        + ", tại vị trí: " + holePosition);
                // CHèn phần tử tại vị trí
                arr[holePosition] = valueToInsert;
            }

            System.out.println("vòng lặp thứ " + i);
            display(arr);
        }
    }

    public void display(int arr[]) {
        int i;
        System.out.print("[");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("]\n");
    }

    public static void main(String[] args) {
        int array[] = {6, 7, 0, 2, 8, 1, 3, 9, 4, 5};

        InsertionSort insertionSort = new InsertionSort();
        System.out.println("Mảng dữ liệu đầu vào: ");
        insertionSort.display(array);
        System.out.println("-----------------------");
        insertionSort.insertionSort(array);
        System.out.println("-----------------------");
        System.out.println("\nMảng sau khi đã sắp xếp: ");
        insertionSort.display(array);
    }

}
