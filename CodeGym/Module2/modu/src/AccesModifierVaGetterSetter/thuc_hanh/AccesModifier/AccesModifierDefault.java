package AccesModifierVaGetterSetter.thuc_hanh.AccesModifier;
//thực hành AccesModifier Default
public class AccesModifierDefault {
}
class A{
    void msg(){
        System.out.println("hello");
    }
}
class Main{
    public static void main(String[] args) {
        A obj = new A();
        obj.msg();
    }
}
