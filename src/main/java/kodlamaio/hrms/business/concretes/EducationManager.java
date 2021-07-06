package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {
    private EducationDao educationDao;


    @Autowired
    public EducationManager(EducationDao educationDao) {
        super();
        this.educationDao = educationDao;
    }



    @Override
    public Result add(Education education) {

        this.educationDao.save(education);
        return new SuccessResult("Data eklendi");
    }

    @Override
    public DataResult<List<Education>> getEducationByCvId(int cvId) {
        return new SuccessDataResult<List<Education>>(this.educationDao.getByCv_Id(cvId),"Data listelendi");
    }
}
