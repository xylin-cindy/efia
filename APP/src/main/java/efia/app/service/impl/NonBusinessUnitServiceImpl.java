package efia.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import efia.app.dao.NonBusinessUnitDao;
import efia.app.entity.NonBusinessUnit;
import efia.app.service.NonBusinessUnitService;
import efia.app.util.LogUtil;

@Service("NonBusinessService")
public class NonBusinessUnitServiceImpl implements NonBusinessUnitService {

    @Autowired
    private NonBusinessUnitDao nonBusinessUnitDao;
    
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job nonBusinessUnitJob;
        
    public NonBusinessUnit getByPkey(String period, Integer rank) {
        return nonBusinessUnitDao.getByPkey(period, rank);
    }
        
    public int countByCondition(Map<String, Object> query) {
        return nonBusinessUnitDao.countByCondition(query);
    }

    public List<NonBusinessUnit> listByCondition(Map<String, Object> query) {
        Map<String, Object> map = new HashMap<String, Object>(query);
        return nonBusinessUnitDao.listByCondition(map);
    }

    @Transactional
    public int create(NonBusinessUnit entity) {
        return nonBusinessUnitDao.create(entity);
    }
    
    @Transactional
    public int update(NonBusinessUnit entity) {
        return nonBusinessUnitDao.update(entity);
    }

    @Transactional
    public int delete(String period, Integer rank) {
        return nonBusinessUnitDao.delete(period, rank);
    }

    /*
    public int reset() {
        try {
            Map<String,JobParameter> parameters = new HashMap<String,JobParameter>();
            parameters.put("timestamp", new JobParameter(Long.valueOf(System.currentTimeMillis() / 1000)));
            JobExecution jobExecution = jobLauncher.run(nonBusinessUnitJob, new JobParameters(parameters));
            StepExecution stepExecution = jobExecution.getStepExecutions().iterator().next();
            return stepExecution.getWriteCount();
        } catch (Exception ex) {
            LogUtil.error(ex, ex);
            return 0;
        }
    }
    */

}
