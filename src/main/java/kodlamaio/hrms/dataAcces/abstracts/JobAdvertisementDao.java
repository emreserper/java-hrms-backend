package kodlamaio.hrms.dataAcces.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {


    @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
            + "(j.id, e.companyName, c.name, p.name, j.description,j.minSalary,j.maxSalary, j.numberOfPeople, j.applicationDeadline,j.creationDate) "
            + "FROM JobAdvertisement j INNER JOIN j.employer e INNER JOIN j.jobPosition p INNER JOIN j.city c "
            + "WHERE j.isActive=true " )
    List<JobAdvertisementDto> getAllIsActiveTrue(); // aktif olan iş ilanlarını listeleme




//    @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
//            + "(j.id, e.companyName, c.name, p.name, j.description,j.minSalary,j.maxSalary, j.numberOfPeople, j.applicationDeadline,j.creationDate) "
//            + "FROM JobAdvertisement j INNER JOIN j.employer e INNER JOIN j.jobPosition p INNER JOIN j.city c "
//            + "WHERE j.creationDate=:creationDate AND j.isActive=true " )
//    List<JobAdvertisementDto> getAllCreationDateAndIsActiveTrue(@Param("creationDate") LocalDate creationDate);

//    List<JobAdvertisement> getByIsActiveTrueAndOrderByCreationDateDesc(); // aktif olan ilanları tarihe göre listeleme

   @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
        + "(j.id, e.companyName, c.name, p.name, j.description,j.minSalary,j.maxSalary, j.numberOfPeople, j.applicationDeadline,j.creationDate) "
        + "FROM JobAdvertisement j INNER JOIN j.employer e INNER JOIN j.jobPosition p INNER JOIN j.city c "
        + "WHERE j.isActive=true AND c.id=:cityId AND p.id =:jobPositionId" )
      List<JobAdvertisementDto> getAllIsActiveTrueAndCity_CityIdAndJobPosition_JobPositionId(int cityId, int jobPositionId);  // şehir ve iş pozisyonuna göre listeleme

    @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
            + "(j.id, e.companyName, c.name, p.name, j.description,j.minSalary,j.maxSalary, j.numberOfPeople, j.applicationDeadline,j.creationDate) "
            + "FROM JobAdvertisement j INNER JOIN j.employer e INNER JOIN j.jobPosition p INNER JOIN j.city c "
            + "WHERE j.isActive=true AND e.id=:employerId" )
        List<JobAdvertisementDto> getAllIsActiveTrueAndEmployer_EmployerId(int employerId); // iş verene göre listeleme

    @Transactional
    @Modifying
    @Query("UPDATE JobAdvertisement j SET j.isActive=:isActive WHERE j.id=:id")
    void setIsActive( Boolean isActive,  int id);


}
