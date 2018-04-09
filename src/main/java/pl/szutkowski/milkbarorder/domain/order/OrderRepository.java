package pl.szutkowski.milkbarorder.domain.order;

public interface OrderRepository {

    Order findIncompleteOrder(OrderId orderId) throws OrderNotFoundException;
    void save(Order order);
}
