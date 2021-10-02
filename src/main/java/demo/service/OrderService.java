package demo.service;

import demo.domain.Order;

/**
 * @author Dhanendra Kumar
 */
public class OrderService {

    private static OrderService instance;
    private EmailService emailService;

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public OrderService() {
        emailService = EmailService.getInstance();
    }

    public void placeOrder(Order order) {
        double priceWithTex = order.getPrice() * 20 / 100;
        order.setPriceWithTex(priceWithTex);
        emailService.sendEmail(order);
    }

    public boolean placeOrder(Order order, String cc) {
        double priceWithTex = order.getPrice() * 20 / 100;
        order.setPriceWithTex(priceWithTex);
        return emailService.sendEmail(order, cc);
    }
}