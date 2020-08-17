package DSADanhSach.bai_tap.LinkedList;


class BaiTapMyLinkedListTest {

    public static void main(String[] args) {
        Student student_1 = new Student("Tôi");
        Student student_2 = new Student("Là");
        Student student_3 = new Student("Một");
        Student student_4 = new Student("Thằng");
        Student student_5 = new Student("Ngốc");

        MyLinkedList<Object> baiTapMyLinkedList = new MyLinkedList<>();
        baiTapMyLinkedList.addFirst(student_2);
        baiTapMyLinkedList.addFirst(student_1);
        baiTapMyLinkedList.addLast(student_3);
        baiTapMyLinkedList.add(student_5,3);
        baiTapMyLinkedList.add(student_4,3);
        baiTapMyLinkedList.printList();

        System.out.println(baiTapMyLinkedList.remove(student_3));
        baiTapMyLinkedList.printList();

        System.out.println(baiTapMyLinkedList.remove(1));
        baiTapMyLinkedList.printList();

        System.out.println(baiTapMyLinkedList.get(1));
        System.out.println(baiTapMyLinkedList.size());

        System.out.println(baiTapMyLinkedList.contains(student_1));

        baiTapMyLinkedList.clone().printList();

        System.out.println(baiTapMyLinkedList.IndexOf(student_5));
    }
}