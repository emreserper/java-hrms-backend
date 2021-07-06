package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvs"})
@NoArgsConstructor
@Table(name = "educations")
public class Education {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "graduation_date")
    private LocalDate graduationDate;

//    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
