package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Table(name="models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Model {
    @Id //Db de primary key alanı
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")//Brandın id si ile bağlantı kuruyor
    private Brand brand;

}


