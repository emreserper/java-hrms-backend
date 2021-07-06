package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CvManager implements CvService {

    private CvDao cvDao;


    @Autowired
    public CvManager(CvDao cvDao) {
        super();
        this.cvDao = cvDao;
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Başarıyla eklendi.");
    }

    @Override
    public DataResult<List<Cv>> getCvByCandidateId(int candidateId) {
        return new SuccessDataResult<List<Cv>>(this.cvDao.getByCandidate_Id(candidateId),"Data listelendi");
    }
}
