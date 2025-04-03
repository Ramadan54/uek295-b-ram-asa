package noseryoung.ch.bookstore.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import noseryoung.ch.bookstore.book.Book;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "status")
    @NotNull
    private String status;
    @Column(name = "comment")
    private String comment;
    @Column(name = "date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Double date;


    @ManyToMany(mappedBy = "order")
    private Set<Book> book;
}
