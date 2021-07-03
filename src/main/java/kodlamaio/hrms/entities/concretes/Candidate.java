package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id") // KAZANANLAR ASLA PES ETMEYENLERDİR.
@EqualsAndHashCode(callSuper = true)
@Table(name="candidates")
public class Candidate extends User{

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="nationality_id")
    private String nationalityId;

    @Column(name="birthdate")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date birthDate;

    @Column(name="is_activated")
    private boolean isActivated;

}
