package StringVaRegex.bai_tap.ValidateSDT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static final String PHONE_NUMBER_REGEX = "^[(]{1}[0-9]{2}[)]{1}[-]{1}[(]{1}[0]{1}[0-9]{9}[)]{1}$";

    public boolean isValidatePhoneNumber(String regex){
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
