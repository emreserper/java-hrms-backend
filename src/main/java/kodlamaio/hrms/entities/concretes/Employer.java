package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = true)
@Table(name="employers")
public class Employer extends User{
    @Column(name="company_name")
    private String companyName;

    @Column(name="web_adress")
    private String webAdress;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="is_activated")
    private boolean isActivated;

    @Column(name="is_confirmed")
    private boolean isConfirmed;
}
