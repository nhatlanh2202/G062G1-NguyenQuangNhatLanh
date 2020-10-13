package bo;

public class Validation {
    public static boolean regexID(String id){
        return (id.matches("^(MB-)\\d{3}$"));
    }
    public static boolean regexArea(String area){
        return area.matches("^\\d{3}\\.[0]$");
    }
    public static boolean regexFloors(String floors){
        return (floors.matches("\\d+") || Integer.parseInt(floors) <= 0);
    }

    public static boolean regexPrice(String price){
        return (price.matches("\\d+") || Double.parseDouble(price) > 10000);
    }

}
