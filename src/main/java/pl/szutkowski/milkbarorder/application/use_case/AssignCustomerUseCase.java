package pl.szutkowski.milkbarorder.application.use_case;

import pl.szutkowski.milkbarorder.application.request.AssignCustomerRequest;
import pl.szutkowski.milkbarorder.domain.customer.Address;
import pl.szutkowski.milkbarorder.domain.customer.Customer;
import pl.szutkowski.milkbarorder.domain.customer.CustomerId;
import pl.szutkowski.milkbarorder.domain.customer.Email;
import pl.szutkowski.milkbarorder.domain.order.*;

public class AssignCustomerUseCase {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    public AssignCustomerUseCase(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public void execute(AssignCustomerRequest request) throws OrderNotFoundException {
        Order order = orderRepository.findIncompleteOrder(new OrderId(request.getOrderId()));

        Customer customer = createCustomer(request);
        order.assignCustomer(customer);
        orderRepository.save(order);
    }

    private Customer createCustomer(AssignCustomerRequest request) {

        CustomerId id = customerRepository.nextId();

        Address address = new Address(
                request.getStreetName(),
                request.getStreetNumber(),
                request.getApartmentNumber(),
                request.getCity(),
                request.getPostalCode()
        );

        return new Customer(
                id,
                request.getFirstName(),
                request.getLastName(),
                request.getPhone(),
                new Email(request.getEmail()),
                address
        );
    }
}
