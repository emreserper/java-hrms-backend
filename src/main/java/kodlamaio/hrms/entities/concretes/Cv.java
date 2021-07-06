package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","education"})
@Table(name="cvs")
public class Cv {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image")
    private String image;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "github")
    private String github;

    @Column(name = "cover_letter")
    private String coverLetter;

   // @JsonIgnore
    @OneToMany(mappedBy = "cv")
    private List<Education> education;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;
}
