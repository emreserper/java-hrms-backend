package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement); // ekleme

    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getAllSorted(); // Tarihe göre listeleme
    DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize); // Sayfalama
    DataResult<List<JobAdvertisementDto>> getAllIsActiveTrue(); // Aktif olan ilanları listeleme

//    DataResult<List<JobAdvertisementDto>> getAllCreationDateAndIsActiveTrue(LocalDate creationDate);
    DataResult<List<JobAdvertisementDto>> getAllIsActiveTrueAndCity_CityIdAndJobPosition_JobPositionId(int cityId, int jobPositionId);  // şehir ve iş pozisyonuna göre listeleme
    DataResult<List<JobAdvertisementDto>> getAllIsActiveTrueAndEmployer_EmployerId(int employerId); // iş verene göre listeleme

    Result setIsActiveFalse(int id);

    Result setIsActiveTrue(int id);
}
