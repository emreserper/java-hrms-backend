package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor // Boş constructor
@AllArgsConstructor // Dolu constructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_positions","cities","employers"})
@Table(name="job_advertisements")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="description")
    @NotBlank
    @NotNull
    private String description;

    @Column(name="min_salary")
    private int minSalary;

    @Column(name="max_salary")
    private int maxSalary;

    @Column(name="number_of_people")
    @NotBlank
    @NotNull
    private String numberOfPeople;

    @Column(name="application_deadline")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate applicationDeadline;

    @Column(name="creation_date")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate creationDate;

    @Column(name="is_active")
    private Boolean isActive;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    @NotBlank
    @NotNull
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    @NotBlank
    @NotNull
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    @NotBlank
    @NotNull
    private City city;

}
