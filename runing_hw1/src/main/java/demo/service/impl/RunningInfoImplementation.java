package demo.service.impl;

import demo.domain.HealthWarningLevel;
import demo.domain.RunningInfo;
import demo.domain.RunningInfoDTO;
import demo.domain.RunninginfoRepository;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RunningInfoImplementation implements RunningInfoService{
    Random rand=new Random();

    private RunninginfoRepository runninginfoRepository;

    @Autowired
    public RunningInfoImplementation(RunninginfoRepository runninginfoRepository)
    {
        this.runninginfoRepository=runninginfoRepository;
    }

    @Override
    public List<RunningInfo> saveRunningInfo(List<RunningInfo> runningInfos) {
        for(int i=0;i<runningInfos.size();i++)
        {
            int heartRate=rand.nextInt(141)+60;
            runningInfos.get(i).setHeartRate(heartRate);
            if(heartRate>=60&&heartRate<=75) {
                runningInfos.get(i).setHealthWarningLevel(HealthWarningLevel.LOW);
            }
            else if(heartRate>75&&heartRate<=120)
            {
                runningInfos.get(i).setHealthWarningLevel(HealthWarningLevel.NORMAL);
            }
            else if(heartRate>120)
            {
                runningInfos.get(i).setHealthWarningLevel(HealthWarningLevel.HIGH);
            }
        }
        return runninginfoRepository.save(runningInfos);
    }

    @Override
    public void deleteById(Long id) {
        runninginfoRepository.deleteById(id);
    }


    @Override
    public List<RunningInfoDTO> findAll(Sort sort) {
        List<RunningInfo> nonDTO=runninginfoRepository.findAll(new Sort(Sort.Direction.DESC, "heartRate"));
        List<RunningInfoDTO> res=new ArrayList<RunningInfoDTO>();
        for(int i=0;i<nonDTO.size();i++)
        {
            res.add(i,new RunningInfoDTO(nonDTO.get(i)));
        }
        return res;
    }


//    @Override
//    public Page<RunningInfo> findByRunningId(String runningId, Pageable pageable) {
//        return runninginfoRepository.findByRunningId(runningId,pageable);
//    }


}
