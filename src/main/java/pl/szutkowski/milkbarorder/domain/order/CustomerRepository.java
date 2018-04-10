package pl.szutkowski.milkbarorder.domain.order;

import pl.szutkowski.milkbarorder.domain.customer.CustomerId;

public interface CustomerRepository {
    CustomerId nextId();
}
