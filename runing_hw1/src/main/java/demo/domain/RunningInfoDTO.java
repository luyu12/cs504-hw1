package demo.domain;

import lombok.Data;

@Data
public class RunningInfoDTO {

    private String runningId;

    private double totalRunningTime;

    public int heartRate;
    private HealthWarningLevel healthWarningLevel;
    private Long id;
    private String username;
    private String address;

    public RunningInfoDTO()
    {

    }
    public RunningInfoDTO(String runningId)
    {
        this.runningId=runningId;
    }

    public RunningInfoDTO(RunningInfo runningInfo)
    {
        this.runningId=runningInfo.getRunningId();
        this.totalRunningTime=runningInfo.getTotalRunningTime();
        this.heartRate=runningInfo.getHeartRate();
        this.id=runningInfo.getId();
        this.username=runningInfo.getUserInfo().getUsername();
        this.address=runningInfo.getUserInfo().getAddress();
        this.heartRate=runningInfo.getHeartRate();
    }


}
