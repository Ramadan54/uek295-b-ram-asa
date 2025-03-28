package noseryoung.ch.bookstore.book;

import jakarta.persistence.*;
import lombok.*;
import noseryoung.ch.bookstore.order.Order;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    private UUID bookId;   // Version 4 UUID

    private String title;
    private String language;
    private double price;

    // Many-to-Many: Die Verwaltung passiert über die "books" in Order
    @ManyToMany(mappedBy = "books")
    private Set<Order> orders;
}
