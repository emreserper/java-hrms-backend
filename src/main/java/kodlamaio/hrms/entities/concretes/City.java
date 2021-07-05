package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor // Boş constructor
@AllArgsConstructor // Dolu constructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"}) // veriyi loop'a sokmamak için kökünde o tekrarlamayı engellemesi için gerekli kod satırı
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<JobAdvertisement> jobAdvertisements;
}
