package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAcces.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>( this.jobPositionDao.findAll(),"Data listelendi");

    }

    @Override
    public Result add(JobPosition jobPosition) {
        if(jobPosition.getName() == "")
        {
            return new ErrorResult("İş pozisyonu alanı boş bırakılamaz.");
        }

        else if(!checkJobPosition(jobPosition.getName())) {
            return new ErrorResult("Bu iş pozisyonu zaten ekli.");
        }
        this.jobPositionDao.save(jobPosition);
        return new SuccessDataResult("İş pozisyonu başarıyla eklendi.");
    }

    private boolean checkJobPosition(String name) {
        if(this.jobPositionDao.getByName(name) == null) {
            return true;
        }
        return false;
    }
}
