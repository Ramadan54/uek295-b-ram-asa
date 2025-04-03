package noseryoung.ch.bookstore.book;

import jakarta.validation.Valid;
import noseryoung.ch.bookstore.order.Order;
import noseryoung.ch.bookstore.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {
    public final OrderService orderService;
    public final BookService bookService;

    public BookController(final OrderService orderService, final BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBook(@Valid @PathVariable UUID bookId) {
        return new ResponseEntity<>(bookService.findById(bookId), HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> getOrder(@Valid @PathVariable UUID orderId) {
        return new ResponseEntity<>(orderService.findOrderById(orderId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }

    @PostMapping("/order")
    public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@Valid @PathVariable UUID bookId, @RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBook(bookId, book), HttpStatus.OK);
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity<Order> updateOrder(@Valid @PathVariable UUID orderId, @RequestBody Order order) {
        return new ResponseEntity<>(orderService.updateOrder(order, orderId), HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Book> deleteBook(@Valid @PathVariable UUID bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<Order> deleteOrder(@Valid @PathVariable UUID orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> searchOrders(
            @Valid
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String comment,
            @RequestParam(required = false) Double date,
            @RequestParam(required = false, defaultValue = "true") boolean includeBooks) {

        return ResponseEntity.ok(orderService.findOrders(status, comment, date, includeBooks));
    }
}
