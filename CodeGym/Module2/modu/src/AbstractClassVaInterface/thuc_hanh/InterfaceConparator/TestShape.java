package AbstractClassVaInterface.thuc_hanh.InterfaceComparator.thuc_hanh;
class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
    }
}
