import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /*returnNumberOfRepetitions();// lessons 1
        returnNumberOfRepetitions2();// lessons 1
        System.out.println("-------------------------------------------");
        returnPositionOfSymbol();// lessons 2
        System.out.println("-------------------------------------------");
        raiseToAPower();// lessons 3
        System.out.println("-------------------------------------------");
        returnStatisticsFromSymbols4();//lessons 4*/
        returnStatisticsFromSymbols5();
    }

    public static void returnNumberOfRepetitions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, write any sentence in english:");
        char[] charsFromSentence = scanner.nextLine().toLowerCase().toCharArray();
        char repeat = 'n';
        int counter = 0;
        for (char elementCharArray : charsFromSentence) {
            if (elementCharArray == repeat) {
                counter++;
            }
        }
        System.out.println("Number of repetitions is: " + counter);
    }

    public static void returnNumberOfRepetitions2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, write any sentence in english:");
        String repetitions = scanner.nextLine().toLowerCase();
        String newCopy = String.copyValueOf(repetitions.toCharArray());
        String symbol = "n";
        System.out.println("Number of repetitions is: " + ((newCopy + "\0").split(symbol).length - 1));
    }

    public static void returnPositionOfSymbol() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, write any sentence in english:");
        String repetitions = scanner.nextLine().toLowerCase();
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = repetitions.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'n') {
                list.add(i);
            }
        }
        System.out.println(list);
    }

    public static void raiseToAPower() {
        Scanner scanner = new Scanner(System.in);
        long result;
        int firstNumber;
        int powNumber;
        do {
            System.out.println("Please, enter a number raise to a power:");
            while (!scanner.hasNextInt()) {
                System.out.println("Error! That not a number! Please enter number!");
                scanner.next();
            }
            firstNumber = scanner.nextInt();
            System.out.println("To what power would you like to raise your number? Please, enter positive number:");
            while (!scanner.hasNextInt()) {
                System.out.println("Error! That not a number! Please enter positive number!");
                scanner.next();
            }
            powNumber = scanner.nextInt();
            result = (long) Math.pow(firstNumber, powNumber);
        } while (powNumber <= 0);
        System.out.println("Result equals: " + result);
    }

    public static void returnStatisticsFromSymbols4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your string which must consist of latin characters:");
        String strScan = scanner.nextLine().toLowerCase();
        char[] charsScan = strScan.toCharArray();
        Set<String> setSymbols = new TreeSet<>();
        String str = "";
        for (char i = 0; i < charsScan.length; i++) {
            long occurrence = strScan.length() - strScan.replaceAll(String.valueOf(charsScan[i]), "").length();
            if (charsScan[i] == ' ') {
                charsScan[i] = '_';
            }
            str = "Symbol: " + charsScan[i] + " has repeats" + " - " + occurrence + " time(s).";
            setSymbols.add(str);
        }
        for (String elementOfSetSymbols : setSymbols) {
            System.out.println(elementOfSetSymbols);
        }
        System.out.println("Total number of symbols in a string: " + strScan.length());
    }

    //method contains() - excluding spaces
    public static void returnStatisticsFromSymbols5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text using from a to z symbols:");
        var inpStr = sc.nextLine();

        int counter = 0;

        for (char alph = 'a'; alph <= (int) 'z'; alph++) {
            if (inpStr.contains(Character.toString(alph))) {
                for (char sym : inpStr.toCharArray()) {
                    if (sym == alph) {
                        counter++;
                    }
                }
                System.out.println(alph + " = " + counter);
                counter = 0;
            }
        }
    }
}

//1. Прочитати рядок із вводу користувача та повернути на консоль кол-во повторених символів 'n' у цьому рядку.
//2. Прочитайте рядок із вводу користувача та збережіть у масиві всі позиції символу 'n' у цьому рядку.
// abcaabca, a -> [0,3,4,7]
//3. Написати програму, яка читає два числа з облікового запису і виводить перше число в ступені другого числа.
//4. Прочитати рядок з облікового запису та повернути користувачеві статистику про те, скільки разів зустрічався кожен із
// символів(користувач може вводити тільки алфавітні латинські символи, нижній регістр)
