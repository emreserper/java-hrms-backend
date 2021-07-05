package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
    private int id;
    private String companyName;

    private String cityName;
    private String jobPositionName;

    private String description;
    private int minSalary;
    private int maxSalary;
    private String numberOfPeople;
    private LocalDate applicationDeadline;
    private LocalDate creationDate;

}
