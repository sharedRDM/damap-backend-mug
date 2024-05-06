package at.medunigraz.damap.rest.dmp.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MUGProject {
    @Size(max = 255)
    private String identifier;
    @Size(max = 4000)
    private String description;
    @Size(max = 255)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date endDate;
}
