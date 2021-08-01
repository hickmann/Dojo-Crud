package ch.hickmann.springbootfromzerotohero.entities;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Builder
@Setter
@Getter
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "national_number")
    private Long nationalNumber;

    private String name;
    private String type;
}
