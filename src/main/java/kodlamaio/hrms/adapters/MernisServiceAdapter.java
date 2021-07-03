package kodlamaio.hrms.adapters;

import kodlamaio.hrms.MernisService.BMVKPSPublicSoap;
import kodlamaio.hrms.Verification.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements MernisCheckService {

    @Override
    public boolean checkIfRealPerson(Candidate candidate) {
        BMVKPSPublicSoap bmvkpsPublicSoap = new BMVKPSPublicSoap();
        boolean result = false;
        try {

            result = bmvkpsPublicSoap.TCKimlikNoDogrula(
                    Long.parseLong(candidate.getNationalityId()),
                    candidate.getFirstName().toUpperCase(),
                    candidate.getLastName().toUpperCase(), 1999 );  }
        catch (Exception e) {
          return result;
        }
        return result;
    }
}
