package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-inc
    @Column(name = "id")
    private int id;

    @Column(name = "plate",unique = true)
    private String plate;//plaka

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "state") // 1-Available 2-Rented 3-Maintenance
    private int state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}

