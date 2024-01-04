import java.util.Scanner;

public class Calc {


    public static int howManyPersons() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = 0;
        System.out.println("На скольких людей разделить счет?");
        while(true){
            numberOfPersons = scanner.nextInt();
            if(numberOfPersons > 1) {
                scanner.close();
                break;
            }
            System.out.println("Некорректный ввод. Введите количество персон");
        }
        return numberOfPersons;
    }


    public static String getProduct() {
        String encoding = System.getProperty("console.encoding", "utf-8");
        String priceList;
        priceList = "Добавленные товары:\n";
        String product = "";
        float price = 0f;
        float sum = 0f;
        Scanner scanner = new Scanner(System.in, encoding);
        while (true) {
            System.out.println("Введите название товара");
            product = scanner.nextLine();
            System.out.println("Введите стоимость товара");
            price = scanner.nextFloat();
            scanner.nextLine();
            priceList += String.format("%s - %.2f\n", product, price);
            sum += price;
            System.out.println("Товар успешно добавлен, если хотите завершить введите\"завершить\"");
            if(scanner.nextLine().toLowerCase().equals("завершить")){
                String ruble = wordRuble(sum);
                sum = (sum / howManyPersons());
                priceList += String.format("Каждый должен заплатить %.2f %s\n ", sum, wordRuble(sum));
                break;
            }
        }
        return priceList;
    }



    public static String wordRuble(float ruble){
        int intRuble = (int) ruble;
        if (intRuble >= 11 && intRuble <= 19)
            return "рублей";
        if (intRuble % 10 >= 2 && intRuble % 10 <= 4)
            return "рубля";
        else if (intRuble % 10 == 1)
            return "рубль";
        else if (intRuble % 10 >= 5 && intRuble % 10 <= 9 || intRuble % 10 == 0)
            return"рублей";
        return null;
    }
}
