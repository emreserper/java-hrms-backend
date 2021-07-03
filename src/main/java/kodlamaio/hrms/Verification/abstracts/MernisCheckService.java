package kodlamaio.hrms.Verification.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisCheckService {
    boolean checkIfRealPerson(Candidate candidate);
}
