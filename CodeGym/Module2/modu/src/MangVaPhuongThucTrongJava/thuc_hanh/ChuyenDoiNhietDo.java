package MangVaPhuongThucTrongJava.thuc_hanh;


public class ChuyenDoiNhietDo {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;

        do {
            System.out.println("Menu.");
            System.out.println("1. Đổi từ Fahrenheit ra Celsius");
            System.out.println("2. Đổi từ Celsius ra Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Nhập sự lựa chọn của bạn: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nhập fahrenheit: ");
                    fahrenheit = input.nextDouble();
                    System.out.println(" Từ Fahrenheit ra Celsius: " + fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.println("Nhập Celsius: ");
                    celsius = input.nextDouble();
                    System.out.println("Từ Celsius ra Fahrenheit: " + celsiusToFahrenheit(celsius));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}