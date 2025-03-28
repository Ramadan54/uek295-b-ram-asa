package noseryoung.ch.bookstore.book;

import jakarta.persistence.*;
import lombok.*;
import noseryoung.ch.bookstore.order.Order;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "book_id")
    private UUID bookId;

    @Column(name = "title")
    private String title;
    @Column(name = "language")
    private String language;
    @Column(name = "price")
    private Double price;


    @ManyToMany(mappedBy = "book")
    private Set<Order> orders;
}
