package DSADanhSach.bai_tap.ArrayList;


public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(5);

        myList.add(0, 10);
        myList.add(1, 11);
        myList.add(2, 12);
        myList.add(3, 13);
        myList.add(4, 14);
        myList.add(5, 15);
        System.out.println("List hiện tại là : " + myList);
        System.out.println("Số lượng phần tử trong list là : " + myList.size());

        myList.add(1, 16);
        System.out.print(myList + " và số cần xóa là : ");
        System.out.print(myList.remove(1) + " , sau khi xóa : ");
        System.out.println(myList);

        myList.add(20);
        System.out.println("List sau khi thêm phần tử 20 vào cuối là : " + myList);

        myList.clone();
        System.out.println("Sau khi clone : " + myList);

        System.out.print("Phần tử 1995 có trong list nên " + myList.contains(19) + " còn ");
        System.out.println("phần tử 1997 không có nên " + myList.contains(17));

        System.out.print("Vị trí của phần tử 1995 là : " + myList.indexOf(8) + " còn ");
        System.out.println("phần tử 1999 không có trong list nên là : " + myList.indexOf(9));

        System.out.println("Phần tử tại vị trí thứ 2 là : " + myList.get(2));

        myList.clear();
        System.out.println("Sau khi clear thì list trở thành : " + myList);
    }
}
