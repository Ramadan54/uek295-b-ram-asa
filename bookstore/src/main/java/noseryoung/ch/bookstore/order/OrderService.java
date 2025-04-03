package noseryoung.ch.bookstore.order;

import noseryoung.ch.bookstore.book.Book;
import noseryoung.ch.bookstore.book.BookRepository;
import noseryoung.ch.bookstore.exception.BookNotFoundException;
import noseryoung.ch.bookstore.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    @Autowired
    public OrderService(final OrderRepository orderRepository, final BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
    }

    public List<Order> findOrders(String status, String comment, Double date, boolean includeBooks) {
        List<Order> filteredOrders = orderRepository.findOrder(status, comment, date);
        if(!includeBooks) {
            for(Order order : filteredOrders){
                order.setBook(null);
            }
        }
        return filteredOrders;
    }

    public Order findOrderById(UUID id){
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }

    public Order createOrder(Order order) {
        Set<Book> connectedBooks = order.getBook().stream()
                .map(b -> bookRepository.findById(b.getBookId())
                        .orElseThrow(() -> new BookNotFoundException("Book not found")))
                .collect(Collectors.toSet());

        order.setBook(connectedBooks);
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order, UUID id) {
        Order updatedOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        updatedOrder.setDate(order.getDate());
        updatedOrder.setComment(order.getComment());
        updatedOrder.setStatus(order.getStatus());

        if (order.getBook() != null && !order.getBook().isEmpty()) {
            Set<Book> connectedBooks = order.getBook().stream()
                    .map(b -> bookRepository.findById(b.getBookId())
                            .orElseThrow(() -> new BookNotFoundException("Book not found")))
                    .collect(Collectors.toSet());

            updatedOrder.setBook(connectedBooks);
        }
        return orderRepository.save(updatedOrder);
    }


    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }
}
