package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

public class JobAdvertisementAddDto {
    private int id;
    private int jobPositionId;
    private String description;
    private int cityId;
    private int minSalary;
    private int maxSalary;
    private String numberOfPeople;
    private LocalDate applicationDeadline;
    private LocalDate creationDate;
    private int employerId;

}
