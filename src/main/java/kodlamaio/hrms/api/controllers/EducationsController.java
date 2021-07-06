package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {
    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        super();
        this.educationService = educationService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody Education education) {

        return this.educationService.add(education);
    }
    @GetMapping("/getEducationByCvId")
    public DataResult<List<Education>> getEducationByCvId(@RequestParam int cvId) {

        return this.educationService.getEducationByCvId(cvId);
    }
}
