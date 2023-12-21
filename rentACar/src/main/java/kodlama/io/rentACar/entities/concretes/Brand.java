package kodlama.io.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Table(name="brands")//Table oluşturuyoruz
@Data //getter-setter oluşturuyor @Getter+@Setter görevi görüyor
@AllArgsConstructor//tüm argümanlar için ctor oluşturutor
@NoArgsConstructor //paramatresiz ctor için tanımlıyoruz
@Entity //Db varlığı olduğunu bilidirir
public class Brand {
    @Id //Db de primary key alanı
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment yapar
    @Column(name="id") //Db de karşılığı olan variable
    private int id;

    @Column(name="name")//Db de karşılığı olan variable
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;


}
