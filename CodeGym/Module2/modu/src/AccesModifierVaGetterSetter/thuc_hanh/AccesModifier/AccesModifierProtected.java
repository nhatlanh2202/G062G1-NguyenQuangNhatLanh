package AccesModifierVaGetterSetter.thuc_hanh.AccesModifier;
//Thực hành AccesModifier protected
class A1{
    protected void msg(){
        System.out.println("Hello");
    }
}
class B1 extends A1{
    public static void main(String[] args) {
        B1 obj = new B1();
        obj.msg();
    }
}

