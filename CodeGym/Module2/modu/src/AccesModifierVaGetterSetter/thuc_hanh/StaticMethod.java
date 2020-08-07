package AccesModifierVaGetterSetter.thuc_hanh;



public class StaticMethod {
        private int rollno;
        private String name;
        private static String college = "BBDIT";

        //hàm khởi tạo để khởi tạo biến
        StaticMethod(int r, String n) {
            rollno = r;
            name = n;
        }

        //phương thức static để thay đổi giá trị của biến static
        static void change() {
            college = "CODEGYM";
        }

        //
        //phương pháp hiển thị giá trị
        void display() {
            System.out.println(rollno + " " + name + " " + college);
        }
}


class TestStaticMethod {
    public static void main(String args[]) {
        StaticMethod.change(); //gọi phương thức thay đổi

        //tạo đối tượng
        StaticMethod s1 = new StaticMethod(111, "Hoang");
        StaticMethod s2 = new StaticMethod(222, "Khanh");
        StaticMethod s3 = new StaticMethod(333, "Nam");

        // gọi phương thức hiển thị
        s1.display();
        s2.display();
        s3.display();
    }
}


