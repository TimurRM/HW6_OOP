public class Program {
    public static void main(String[] args) {
        OrderInput orderInput = new OrderInput();
        Order order = orderInput.inputFromConsole();

        OrderFile orderRepository = new OrderFile();
        orderRepository.saveToJson(order);

        System.out.printf("Общая сумма чека: %.2f%n", order.getTotalAmount());
    }
}
