package noseryoung.ch.bookstore.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Query("SELECT o FROM Order o WHERE (:comment is NULL OR o.comment LIKE %:comment%) " +
            "AND (:status is NULL OR o.status = :status) " +
            "AND (:date is NULL OR o.date = :date)")
    List<Order>findOrder(@Param("status") String status,
                         @Param("comment") String comment,
                         @Param("date") Double date);
}
