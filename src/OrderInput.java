import java.util.Scanner;
import java.util.Locale;

public class OrderInput {
    private Scanner scanner = new Scanner(System.in).useLocale(Locale.US); // Используем локаль, где разделитель - точка

    public Order inputFromConsole() {
        String clientName = prompt("Имя клиента: ");
        String product = prompt("Продукт: ");
        int qnt = parseIntWithRetry("Количество: ");
        double price = parseDoubleWithRetry("Цена: ");

        return new Order(clientName, product, qnt, price);
    }

    private String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private int parseIntWithRetry(String message) {
        while (true) {
            try {
                return Integer.parseInt(prompt(message));
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное числовое значение. Пожалуйста, попробуйте еще раз.");
            }
        }
    }

    private double parseDoubleWithRetry(String message) {
        while (true) {
            try {
                String input = prompt(message).replace(',', '.'); // Заменяем запятую на точку для парсинга
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное числовое значение. Пожалуйста, попробуйте еще раз.");
            }
        }
    }
}

