package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/cvs")
public class CvsController {
    private CvService cvService;

    @Autowired
    public CvsController(CvService cvService) {
        super();
        this.cvService = cvService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody Cv cv) {

        return this.cvService.add(cv);
    }

    @GetMapping("/getCVByJobseekerId")
    public DataResult<List<Cv>> getCvByCandidateId(@RequestParam int candidateId) {

        return this.cvService.getCvByCandidateId(candidateId);
    }
}
