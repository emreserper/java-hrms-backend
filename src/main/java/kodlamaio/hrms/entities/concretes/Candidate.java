package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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
    @NotBlank
    @NotNull
    private String firstName;

    @Column(name="last_name")
    @NotBlank
    @NotNull
    private String lastName;

    @Column(name="nationality_id")
    @NotBlank
    @NotNull
    private String nationalityId;

    @Column(name="birthdate")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;

    @Column(name="is_activated")
    private boolean isActivated;

}
