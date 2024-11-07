package gym.heavymetal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "visits")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class VisitsEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sportsman_id", nullable = false)
    private SportsmanEntity sportsman;

    @ManyToOne
    @JoinColumn(name = "purchased_subscription_id", nullable = false)
    private PurchasedSubscriptionEntity purchasedSubscription;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
}
