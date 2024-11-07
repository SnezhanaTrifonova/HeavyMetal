package gym.heavymetal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "sportsman")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SportsmanEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String name;

    private String surname;

    private String barcode;
}
