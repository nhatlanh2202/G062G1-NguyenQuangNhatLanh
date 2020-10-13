package common;

public class Validation {
    public static boolean regexID(String id) {
        return !id.matches("^([A-Z0-9]){3}(-([A-Z0-9]){2}){2}$");
    }

    // Là số thực lớn hơn 0
    public static boolean regexAreaAndPrice(String number) {
        return !number.matches("\\d+([.]\\d+)?") || !(Double.parseDouble(number) > 20);
    }

    public static boolean regexPrice(String number){
        return !number.matches("\\d+([.]\\d+)?") || ! (Double.parseDouble(number) > 1000000);
    }

    // Là số nguyên dương
    public static boolean regexPositiveIntegers(String number) {
        return !number.matches("\\d+") || Integer.parseInt(number) > 15;
    }

//    public static boolean regexAge(String age) {
//        return !age.matches("\\d+") || Integer.parseInt(age) < 18;
//    }
//
//    public static boolean regexEmail(String email) {
//        return !email.matches("^\\w{3,}@[a-z]{3,7}\\.[a-z]{2,3}$");
//    }
//
//    public static boolean regexPhoneNumber(String phoneNumber) {
//        return !phoneNumber.matches("^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$");
//    }
}
