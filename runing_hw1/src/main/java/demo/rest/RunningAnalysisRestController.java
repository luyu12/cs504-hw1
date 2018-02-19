package demo.rest;

import demo.domain.RunningInfo;
import demo.domain.RunningInfoDTO;
import demo.service.RunningInfoService;
import demo.service.impl.RunningInfoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningAnalysisRestController {
    private RunningInfoService runningInfoService;

    @Autowired
    public RunningAnalysisRestController(RunningInfoService runningInfoService) {
        this.runningInfoService = runningInfoService;
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInfo> runningInfoList) {
        this.runningInfoService.saveRunningInfo(runningInfoList);
    }
    @RequestMapping(value = "/runningInfo/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        this.runningInfoService.deleteById(id);
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public List<RunningInfoDTO> findAll(Sort sort) {
        return runningInfoService.findAll(sort);
    }


//    @RequestMapping(value = "/runningInfo/{runningId}", method = RequestMethod.GET)
//    public Page<RunningInfo> findByRunningId(@PathVariable String runningId,
//                                             @RequestParam("page") int page,
//                                             @RequestParam(value = "size", required = false, defaultValue = "2") int size
//    ) {
//        PageRequest request = new PageRequest(page, size, Sort.Direction.DESC, "heartRate");
//        return runningInfoService.findByRunningId(runningId, request);
//    }


}
