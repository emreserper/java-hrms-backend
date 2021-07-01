package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="job_positions")
public class JobPosition {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    public JobPosition(){

    }
    public JobPosition(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
