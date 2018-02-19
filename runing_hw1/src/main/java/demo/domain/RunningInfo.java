package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RunningInfo {


    private final String runningId;
    @Id
    @GeneratedValue
    private Long id;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    public int heartRate;
    private Date Timestamp = new Date();
    public HealthWarningLevel healthWarningLevel;



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "username")),
            @AttributeOverride(name = "address", column = @Column(name = "address"))
    })
    private UserInfo userInfo;

    public RunningInfo()
    {
        runningId="";
    }

    public RunningInfo(String runningId) {
        this.runningId = runningId;

    }


}
