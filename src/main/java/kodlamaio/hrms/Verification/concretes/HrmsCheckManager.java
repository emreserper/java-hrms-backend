package kodlamaio.hrms.Verification.concretes;

import kodlamaio.hrms.Verification.abstracts.HrmsCheckService;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class HrmsCheckManager implements HrmsCheckService {

    @Override
    public boolean checkIfConfirmHrms(User user) {
        return true;
    }
}
