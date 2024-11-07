package gym.heavymetal.entity;

import gym.heavymetal.dto.CountVisits;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "subscription")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class SubscriptionEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    @Column(name = "count_visits")
    private Integer countVisits;

    private BigDecimal price;

    @Column(name = "action_time")
    private Integer actionTime;
}
