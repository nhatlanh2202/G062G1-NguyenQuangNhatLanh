package CaseStudy.Commons;

import CaseStudy.Models.House;
import CaseStudy.Models.Room;
import CaseStudy.Models.Villa;

import java.util.Calendar;
import java.util.Scanner;


public class FuncValidate {
    private static String regex ="";
    private static Scanner sc;


    ///// check Name
    public static boolean checkNameService(String str){
        regex="^[A-Z][\\w]+([\\s][A-Z][\\w]+)*$";
        return str.matches(regex);
    }
    ///Check Name VietNames
    public static boolean checkNameCustomer(String str){
        regex="^[A-Z][\\w]+([\\s][A-Z][\\w]+)*$";
        return str.matches(regex);
    }
    // check Birthday
    public static boolean checkBirthday(String str){
        regex="^(([0][1-9])|([1-2][0-9])|([3][0-1]))\\/(([0][0-9])|([1][0-2]))\\/(([1][9][0-9]{2})|([2][0-9]{3}))$";
        Calendar cal = Calendar.getInstance();
        int nowYear=cal.get(Calendar.YEAR);
        System.out.println("This Year: " + nowYear);
        String yearStr=str.substring(6);
        int year=Integer.parseInt(yearStr);
        boolean checkAge=nowYear-year>18;
        return str.matches(regex)&&checkAge;
    }

    //////// check service
    public static boolean checkConveninent(String name){
        regex="^(massage)|(karaoke)|(food)|(drink)|(car)$";
        return name.matches(regex);
    }
    //////// check double
    public static double checkValidNumberDouble(String content,String errMess){
        while (true)
            try {
                sc=new Scanner(System.in);
                System.out.println(content);
                return sc.nextDouble();
            }
            catch (Exception ex){
                System.out.println(errMess);
            }
    }
    //////////check int
    public static int checkValidNumberInt(String content,String errMess){
        while (true)
            try {
                sc=new Scanner(System.in);
                System.out.println(content);
                return sc.nextInt();
            }
            catch (Exception ex){
                System.out.println(errMess);
            }
    }
    public static boolean checkGender(String str){
        regex="^(([uU][nN][kK][nN][oO][wW])|([fF][eE][mM][aA][lL][eE])|([mM][aA][lL][eE]))$";
        return str.matches(regex);
    }
    /// format Gender
    public static String formatGender(String gender){
        gender=gender.toLowerCase();
        char[]arr=gender.toCharArray();
        arr[0]=Character.toUpperCase(arr[0]);
        String lastGender="";
        for (char element: arr) {
            lastGender+=element;
        }
        return lastGender;
    }
    // check Email
    public static boolean checkEmail(String str){
        regex="^[a-zA-Z][\\w]+@[a-z]+[\\.][a-z]+([\\.][a-z]+)*$";
        return str.matches(regex);
    }
    ///check IDCustomer (9 number)
    public static boolean checkID(String str){
        regex="^[0-9]{3}[ ][0-9]{3}[ ][0-9]{3}$";
        return str.matches(regex);
    }
    public static boolean checkIdSerice(String str, Object services){
        String parttern = null;
        if(services instanceof Villa){
            parttern = "^SVVL-\\d{4}$";
        }else if(services instanceof House){
            parttern = "^SVHO-\\d{4}$";
        }else if(services instanceof Room){
            parttern = "^SVRO-\\d{4}$";
        }
        return str.matches(parttern);
    }
}
