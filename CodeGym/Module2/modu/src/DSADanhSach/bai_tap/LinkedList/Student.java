package DSADanhSach.bai_tap.LinkedList;

class Student{
    private String name;

    Student() {
    }

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
