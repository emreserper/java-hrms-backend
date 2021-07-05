package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessDataResult("İş ilanı eklendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"creationDate");
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "Data Listelendi");
    } // tarihe göre listeleme

    @Override
    public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<JobAdvertisement>> (this.jobAdvertisementDao.findAll(pageable).getContent());
    } // sayfalama

    @Override
    public DataResult<List<JobAdvertisementDto>> getAllIsActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAllIsActiveTrue(), " Aktif Datalar Listelendi");
    } // Aktif olan ilanları listeleme





//    @Override
//    public DataResult<List<JobAdvertisementDto>> getAllCreationDateAndIsActiveTrue(LocalDate creationDate) {
//        return new SuccessDataResult<List<JobAdvertisementDto>>(
//                this.jobAdvertisementDao.getAllCreationDateAndIsActiveTrue(creationDate),"Tarihe göre aktif datalar listelendi");
//    }
//
    @Override
    public DataResult<List<JobAdvertisementDto>> getAllIsActiveTrueAndCity_CityIdAndJobPosition_JobPositionId(int cityId, int jobPositionId) {
        return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAllIsActiveTrueAndCity_CityIdAndJobPosition_JobPositionId(cityId, jobPositionId), "Şehre ve pozisyona göre aktif data Listelendi");
    }
//
    @Override
    public DataResult<List<JobAdvertisementDto>> getAllIsActiveTrueAndEmployer_EmployerId(int employerId) {
      return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAllIsActiveTrueAndEmployer_EmployerId(employerId),"İş verene göre aktif data Listelendi");

    }

    @Override
    public Result setIsActiveFalse(int id) {
        this.jobAdvertisementDao.setIsActive(false, id);
        return new SuccessResult("İş ilanı pasif hale getirildi.");
    }

    @Override
    public Result setIsActiveTrue(int id) {
        this.jobAdvertisementDao.setIsActive(true, id);
        return new SuccessResult("İş ilanı aktif hale getirildi.");
    }


}
