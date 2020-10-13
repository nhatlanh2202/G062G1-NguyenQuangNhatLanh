package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {


    public static final String REGEX_QUANTITY = "^[1-9][\\d]*$";


    public static boolean isValidQuantity(String quantity) {

        Pattern pattern = Pattern.compile(REGEX_QUANTITY);
        Matcher matcher = pattern.matcher(quantity);

        return matcher.matches();
    }

   

}
