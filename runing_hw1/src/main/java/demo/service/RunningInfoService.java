package demo.service;

import demo.domain.RunningInfo;
import demo.domain.RunningInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RunningInfoService {
    List<RunningInfo> saveRunningInfo(List<RunningInfo> runningInfos);

    void deleteById(Long id);

    //Page<RunningInfo> findByRunningId(@Param("runningId") String runningId, Pageable pageable);
    List<RunningInfoDTO> findAll(Sort sort);
}
