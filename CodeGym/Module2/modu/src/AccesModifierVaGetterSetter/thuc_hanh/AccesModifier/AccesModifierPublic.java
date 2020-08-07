package AccesModifierVaGetterSetter.thuc_hanh.AccesModifier;
// Thực hành AccesModifier Public
class A2{
    public void msg(){
        System.out.println("Hello ");
    }
}
class B2{
    public static void main(String[] args) {
        A2 obj = new A2();
        obj.msg();
    }
}
