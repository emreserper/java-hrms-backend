package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.Verification.abstracts.EmailCheckService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAcces.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailCheckService emailCheckService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,EmailCheckService emailCheckService) {
        super();
        this.employerDao = employerDao;
        this.emailCheckService = emailCheckService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi.");
    }

    @Override
    public Result add(Employer employer) {
        final String EMAIL_PATTERN ="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(employer.getEmail());

        if (!matcher.matches()){
            return new ErrorResult("Lütfen geçerli bir email adresi giriniz.");
        }

        else if(!checkEmail(employer.getEmail())) {
            return new ErrorResult("Bu email adresi zaten kullanılmaktadır.");
        }

        else if(!this.emailCheckService.checkIfRealEmail(employer)) {
            return new ErrorResult("Lütfen email adresinizi doğrulayın.");
        }

        else if(!employer.getPassword().equals(employer.getPasswordVerification())){
            return new ErrorResult("Girmiş olduğunuz şifreler eşleşmiyor.");
        }

        this.employerDao.save(employer);
        return new SuccessResult("Kayıt başarılı!");
    }


    private boolean checkEmail(String email) {
        if (this.employerDao.getByEmail(email) == null) {
            return true;
        }
        return false;
    }


}
