import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {


    public static int howManyPersons() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На скольких людей разделить счет?");
        while(true){
            int numberOfPersons = 0;
            try {
                numberOfPersons = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Некорректный ввод. Введите количество персон");
                scanner.nextLine();
            }
            if(numberOfPersons > 1) {
                return numberOfPersons;
            }
            else {
                System.out.println("Некорректный ввод. Введите количество персон");
            }
        }
    }



    public static String getProduct() {
        String priceList;
        priceList = "Добавленные товары:\n";
        String product = "";
        float price = 0f;
        float sum = 0f;
        int quantityPerson = howManyPersons();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название товара");
            while(true) {
                product = scanner.nextLine();
                if(product.trim().length() == 0) {
                    System.out.println("Кажется вы забыли ввести название товара, попробуйте ещё раз");
                }
                else {
                    break;
                }
            }
            System.out.println("Введите стоимость товара");
            while(true) {
                try {
                    price = scanner.nextFloat();
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный ввод. Введите стоимость товара");
                    scanner.nextLine();
                    continue;
                }
                if(price > 0) {
                    break;
                }
                else {
                    System.out.println("Некорректный ввод. Введите стоимость товара");
                }
            }
            scanner.nextLine();
            priceList += String.format("%s - %.2f %s\n", product, price, wordRuble(price));
            sum += price;
            System.out.println("Товар успешно добавлен, если хотите завершить введите \"завершить\"");
            if(scanner.nextLine().toLowerCase().equals("завершить")){
                String ruble = wordRuble(sum);
                sum = (sum / quantityPerson);
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