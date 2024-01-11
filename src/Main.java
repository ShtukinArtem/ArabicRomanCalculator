import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    static class Converter {
        private static final int[] arabicValues = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        private static final String[] romanValues = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public static int romanToArab(String value) {
            switch (value) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public static String arabToRoman(int input) {
            if (input < 1) {
                throw new ArithmeticException();
            }

            StringBuilder result = new StringBuilder();
            int i = 0;

            while (input > 0) {
                if (input >= arabicValues[i]) {
                    result.append(romanValues[i]);
                    input -= arabicValues[i];
                } else {
                    i++;
                }
            }

            return result.toString();
        }
    }

    public static String calc(String input) {
        String[] numbers = input.split(" ");
        if (numbers.length != 3) {
            throw new IllegalArgumentException();
        }

        int firstNum;
        int secondNum;
        boolean isRome = false;
        try {
            firstNum = Integer.parseInt(numbers[0]);
            secondNum = Integer.parseInt(numbers[2]);
        } catch (NumberFormatException nfe) {
            firstNum = Converter.romanToArab(numbers[0]);
            secondNum = Converter.romanToArab(numbers[2]);
            isRome = true;
        }
        String operator = numbers[1];

        if (firstNum < 1 || secondNum < 1 || firstNum > 10 || secondNum > 10) {
            throw new IllegalArgumentException();
        }
        int result;
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            default:
                throw new IllegalArgumentException();
        }
        if (isRome) {
            return Converter.arabToRoman(result);
        }
        return String.valueOf(result);
    }
}