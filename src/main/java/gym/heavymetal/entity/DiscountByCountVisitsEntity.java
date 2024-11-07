package gym.heavymetal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "discount_by_count_visits")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class DiscountByCountVisitsEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "percent")
    private Integer percent;

    @Column(name = "count_visits")
    private Integer countVisits;
}
