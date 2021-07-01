package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>>  getAll();

}
