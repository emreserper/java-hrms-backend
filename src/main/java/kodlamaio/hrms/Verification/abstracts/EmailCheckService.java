package kodlamaio.hrms.Verification.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface EmailCheckService {
    boolean checkIfRealEmail(User user);
}
