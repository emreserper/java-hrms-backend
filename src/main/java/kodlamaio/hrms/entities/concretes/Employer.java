package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = true)
@Table(name="employers")
public class Employer extends User{
    @Column(name="company_name")
    @NotBlank
    @NotNull
    private String companyName;

    @Column(name="web_adress")
    @NotBlank
    @NotNull
    private String webAdress;

    @Column(name="phone_number")
    @NotBlank
    @NotNull
    private String phoneNumber;

    @Column(name="is_activated")
    private boolean isActivated;

    @Column(name="is_confirmed")
    private boolean isConfirmed;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}
