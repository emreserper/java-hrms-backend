package kodlamaio.hrms.dataAcces.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
}
