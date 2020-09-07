package StringVaRegex.bai_tap.ValidateSDT;

public class Main {
    private static final String[] Invalid = {"(84)-(0978489648)"};
    private static final String[] Illegal = {"(a8)-(22222222)"};

    public static void main(String[] args) {
        ValidatePhoneNumber validatePhoneNumber = new ValidatePhoneNumber();
        boolean isValid;

        for(String phoneNumber : Invalid){
            isValid  = validatePhoneNumber.isValidatePhoneNumber(phoneNumber);
            System.out.println("Phone number: " + phoneNumber + " is valid : " + isValid);
        }
        System.out.println("-------------------------");
        for(String phoneNumber : Illegal){
            isValid = validatePhoneNumber.isValidatePhoneNumber(phoneNumber);
            System.out.println("Phone number: " + phoneNumber + " is valid: " + isValid);
        }
    }
}
