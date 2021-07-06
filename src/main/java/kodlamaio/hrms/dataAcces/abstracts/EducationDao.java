package kodlamaio.hrms.dataAcces.abstracts;

import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {

    List<Education> getByCv_Id(int cvId);
}
