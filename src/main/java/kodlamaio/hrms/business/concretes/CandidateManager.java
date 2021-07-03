package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.Verification.abstracts.EmailCheckService;
import kodlamaio.hrms.Verification.abstracts.MernisCheckService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAcces.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private MernisCheckService mernisCheckService;
    private EmailCheckService emailCheckService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao,MernisCheckService mernisCheckService,EmailCheckService emailCheckService) {
        super();
        this.candidateDao = candidateDao;
        this.mernisCheckService = mernisCheckService;
        this.emailCheckService = emailCheckService;

    }
    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "İş arayanlar listelendi.");
    }
    @Override
    public Result add(Candidate candidate) {
        final String EMAIL_PATTERN ="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(candidate.getEmail());

        if(candidate.getFirstName() == "" || candidate.getLastName() == ""
                || candidate.getEmail() == "" || candidate.getPassword() == ""
                || candidate.getNationalityId() == "" || candidate.getBirthDate() == null)
        {

            return new ErrorResult("Tüm alanları doldurduğunuzdan emin olun.");
        }
        else if (!this.mernisCheckService.checkIfRealPerson(candidate)){
            return new ErrorResult("Girdiğiniz bilgiler mernis doğrulamasından geçemedi.");
       }

        else if (!matcher.matches()){
            return new ErrorResult("Lütfen geçerli bir email adresi giriniz.");
        }

        else if(!checkEmail(candidate.getEmail())) {
            return new ErrorResult("Bu email adresi zaten kullanılmaktadır.");
        }

        else if(!checkNationalityId(candidate.getNationalityId())) {
            return new ErrorResult("Bu TC Kimlik numarası zaten kullanılmaktadır.");
        }

        else if(!this.mernisCheckService.checkIfRealPerson(candidate)) {
            return new ErrorResult("Girmiş olduğunuz bilgiler Mernis doğrulamasından geçememiştir.");
        }

        else if(!this.emailCheckService.checkIfRealEmail(candidate)) {
            return new ErrorResult("Lütfen email adresinizi doğrulayın.");
        }

        else if(!candidate.getPassword().equals(candidate.getPasswordVerification())){
            return new ErrorResult("Girmiş olduğunuz şifreler eşleşmiyor.");
        }

        this.candidateDao.save(candidate);
        return new SuccessResult("Kayıt başarılı!");
    }

    private boolean checkEmail(String email) {
        if (this.candidateDao.getByEmail(email) == null) {
            return true;
        }
        return false;
    }

    private boolean checkNationalityId(String nationalityId) {
        if(this.candidateDao.getByNationalityId(nationalityId) == null) {
            return true;
        }
        return false;
    }

}
