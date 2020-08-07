package AccesModifierVaGetterSetter.thuc_hanh.AccesModifierPrivate;

// thực hành Private
class A{
    int data = 40;
    int msg(){
        System.out.print("Hello ");
        return data;
    }
}
class Simple{
    static void main(String[] args){
        A obj = new A();
        System.out.println(obj.data);
        obj.msg();
    }
}
class Main{
    public static void main(String[] args) {
        A simple = new A();
        System.out.println(simple.msg());
    }
}
