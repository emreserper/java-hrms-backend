package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/jobAdvertisements")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;


    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        super();
        this.jobAdvertisementService = jobAdvertisementService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getallByPage")
    DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize){
        return this.jobAdvertisementService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getallDesc")
    DataResult<List<JobAdvertisement>> getAllSorted() {
        return this.jobAdvertisementService.getAllSorted();
    }

    @GetMapping("/getAllIsActiveTrue")
    public DataResult<List<JobAdvertisementDto>> getAllIsActiveTrue(){
        return this.jobAdvertisementService.getAllIsActiveTrue();
    }

//   @GetMapping("/getAllCreationDateAndIsActiveTrue")
//    public DataResult<List<JobAdvertisementDto>>getAllCreationDateAndIsActiveTrue(@RequestParam LocalDate creationDate){
//        return this.jobAdvertisementService.getAllCreationDateAndIsActiveTrue(creationDate);
//    }

    @GetMapping("/getAllIsActiveTrueAndCity_CityIdAndJobPosition_JobPositionId")
    public DataResult<List<JobAdvertisementDto>> getAllIsActiveTrueAndCity_CityIdAndJobPosition_JobPositionId(@RequestParam int cityId, @RequestParam int jobPositionId){
        return this.jobAdvertisementService.getAllIsActiveTrueAndCity_CityIdAndJobPosition_JobPositionId(cityId,jobPositionId);
    }
    @GetMapping("/getByIsActiveTrueAndEmployer")
    public DataResult<List<JobAdvertisementDto>> getAllIsActiveTrueAndEmployer_EmployerId(@RequestParam int employerId){
        return this.jobAdvertisementService.getAllIsActiveTrueAndEmployer_EmployerId(employerId);
    }

    @PostMapping( "/setIsActiveFalse")
    public Result setIsactiveFalse(int id){
        return this.jobAdvertisementService.setIsActiveFalse(id);
    }

    @PostMapping( "/setIsActiveTrue")
    public Result setIsactiveTrue(int id){
        return this.jobAdvertisementService.setIsActiveTrue(id);
    }
}
