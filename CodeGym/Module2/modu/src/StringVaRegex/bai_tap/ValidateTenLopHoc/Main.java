package StringVaRegex.bai_tap.ValidateTenLopHoc;

public class Main {
    private static final String[] Invalid = {"C0318G"};
    private static final String[] Illegal = {" M0318G","P0323A"};

    public static void main(String[] args) {
        ValidateClassName validateClassName = new ValidateClassName();
        boolean isInvalid;
        for(String name : Invalid){
            isInvalid = validateClassName.isValidateClassName(name);
            System.out.println("Class name: " + name + " is valid: " + isInvalid);
        }
        System.out.println("--------------------");
        for (String name : Illegal){
            isInvalid = validateClassName.isValidateClassName(name);
            System.out.println("Class name: " + name + " is valid: " + isInvalid);
        }
    }
}
