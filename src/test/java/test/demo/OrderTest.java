package test.demo;

import demo.domain.Order;
import demo.service.OrderService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    static OrderService orderService;

    @BeforeAll
    static void configure() {
        orderService = new OrderService();
    }

    @Test
    @DisplayName("Order test")
    void testOrderException() {
        Order tshirtOrder = new Order(2,"White T-shirt", 200);

        Throwable exception = assertThrows(RuntimeException.class, () -> orderService.placeOrder(tshirtOrder));
        assertEquals(tshirtOrder.getPriceWithTex(), 40, "Price after tax doesn't match");
    }

    @Test
    @DisplayName("Order multi parameter test")
    void testOrderBoolean() {
        Order tshirtOrder = new Order(1,"Orange T-shirt", 500);

        //assertTrue(orderService.placeOrder(tshirtOrder));
        assertEquals(orderService.placeOrder(tshirtOrder, tshirtOrder.getItemName()), true, "Price after tax doesn't match");
        assertEquals(tshirtOrder.getPriceWithTex(), 100, "Price after tax doesn't match");
    }
}
