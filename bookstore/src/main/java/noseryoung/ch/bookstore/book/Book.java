package noseryoung.ch.bookstore.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import noseryoung.ch.bookstore.order.Order;
import org.springframework.format.annotation.NumberFormat;

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
    @NotNull
    private String title;
    @Column(name = "language")
    private String language;
    @Column(name = "price")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double price;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "book_order",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    @JsonBackReference
    private Set<Order> order;
}
