package gym.heavymetal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "purchased_subscription")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class PurchasedSubscriptionEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sportsman_id", nullable = false)
    private SportsmanEntity sportsman;

    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private SubscriptionEntity subscription;

    @Column(name = "started_date", nullable = false)
    private LocalDateTime startedDate;

    @Column(name = "stopped_date")
    private LocalDateTime stoppedDate;

    private BigDecimal paid;

    @Column(columnDefinition = "boolean default true")
    private boolean active;
}
