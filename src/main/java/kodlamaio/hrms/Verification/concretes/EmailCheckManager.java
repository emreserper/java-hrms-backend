package kodlamaio.hrms.Verification.concretes;

import kodlamaio.hrms.Verification.abstracts.EmailCheckService;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class EmailCheckManager implements EmailCheckService {
    @Override
    public boolean checkIfRealEmail(User user) {
        return true;
    }
}
