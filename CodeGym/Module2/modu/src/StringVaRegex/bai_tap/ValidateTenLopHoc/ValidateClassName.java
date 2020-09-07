package StringVaRegex.bai_tap.ValidateTenLopHoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassName {
    private static final String CLASS_NAME_REGEX = "^[CAP][0-9]{4}[GHIKLM]$";

    public ValidateClassName() {
    }

    public boolean isValidateClassName(String regex){
        Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
