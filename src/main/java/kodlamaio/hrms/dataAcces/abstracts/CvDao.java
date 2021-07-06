package kodlamaio.hrms.dataAcces.abstracts;

import kodlamaio.hrms.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvDao  extends JpaRepository<Cv, Integer> {

    List<Cv> getByCandidate_Id(int candidateId);
}
