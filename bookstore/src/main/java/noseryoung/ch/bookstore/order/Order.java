package noseryoung.ch.bookstore.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String status;
    @Column(name = "comment")
    private String comment;
    @Column(name = "date")
    private Double date;


    @ManyToMany(mappedBy = "order")
    private Set<Order> orders;
}
