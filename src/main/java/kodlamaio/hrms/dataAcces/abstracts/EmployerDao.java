package kodlamaio.hrms.dataAcces.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer getByEmail(String email);
}
