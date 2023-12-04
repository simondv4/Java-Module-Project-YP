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

    public static String[] getProduct() {
        String encoding = System.getProperty("console.encoding", "utf-8");
        String[] priceList = new String[2];
        priceList[0] = "Добавленные товары:\n";
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
            priceList[0] += String.format("%s - %.2f\n", product, price);
            sum += sum;
            System.out.println("Товар успешно добавлен, если хотите завершить введите\"завершить\"");
            if(scanner.nextLine().toLowerCase().equals("завершить")){
                priceList[1] = String.format("%.2f", sum);
                break;
            }
        }
        return priceList;
    }
}
