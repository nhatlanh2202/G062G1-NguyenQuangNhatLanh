package IntroductionToJava.bai_tap;


import java.util.Scanner;

public class DocSoBangChu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần đọc");
        int number = sc.nextInt();
        String text = "";
        if (number < 1000) {
            int hundreds = number / 100;
            int tens = (number % 100) / 10;
            int ones = (number % 100) % 10;
            if (hundreds != 0) {
                switch (hundreds) {
                    case 1:
                        text += " One";
                        break;
                    case 2:
                        text += " Two";
                        break;
                    case 3:
                        text += " Three";
                        break;
                    case 4:
                        text += " Four";
                        break;
                    case 5:
                        text += " Five";
                        break;
                    case 6:
                        text += " Six";
                        break;
                    case 7:
                        text += " Seven";
                        break;
                    case 8:
                        text += " Eight";
                        break;
                    case 9:
                        text += " Nine";
                        break;
                }
                text += " hundreds";
            }
            if (tens == 1) {
                switch (tens) {
                    case 0:
                        text += " Ten";
                        break;
                    case 1:
                        text += " Eleven";
                        break;
                    case 2:
                        text += " Twelve";
                        break;
                    case 3:
                        text += " Thirteen";
                        break;
                    case 4:
                        text += " Fourteen";
                        break;
                    case 5:
                        text += " Fifteen";
                        break;
                    case 6:
                        text += " Sixteen";
                        break;
                    case 7:
                        text += " Seventeen";
                        break;
                    case 8:
                        text += " Eighteen";
                        break;
                    case 9:
                        text += " Nineteen";
                        break;
                }
            } else {
                if (tens != 0) {
                    switch (tens) {
                        case 2:
                            text += " Twen";
                            break;
                        case 3:
                            text += " Thir";
                            break;
                        case 4:
                            text += " For";
                            break;
                        case 5:
                            text += " Fif";
                            break;
                        case 6:
                            text += " Six";
                            break;
                        case 7:
                            text += " Seven";
                            break;
                        case 8:
                            text += " Eight";
                            break;
                        case 9:
                            text += " Nine";
                            break;
                    }
                    text += "ty";
                }
                switch (ones) {
                    case 1:
                        text += " One";
                        break;
                    case 2:
                        text += " Two";
                        break;
                    case 3:
                        text += " Three";
                        break;
                    case 4:
                        text += " Four";
                        break;
                    case 5:
                        text += " Five";
                        break;
                    case 6:
                        text += " Six";
                        break;
                    case 7:
                        text += " Seven";
                        break;
                    case 8:
                        text += " Eight";
                        break;
                    case 9:
                        text += " Nine";
                        break;
                }
            }
        }else{
            System.out.println(" out of abilyti ");
        }
        System.out.printf("%s", text);
    }
}
