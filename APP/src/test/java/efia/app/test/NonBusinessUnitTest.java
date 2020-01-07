package efia.app.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import efia.app.dao.NonBusinessUnitDao;
import efia.app.entity.NonBusinessUnit;
import efia.app.service.NonBusinessUnitService;
import efia.app.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)   
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NonBusinessUnitTest {
    
    private static final String path = "/Trade.csv";
    
    @Autowired
    private NonBusinessUnitService nonBusinessUnitService;
    @Autowired
    private NonBusinessUnitDao nonBusinessUnitDao;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job nonBusinessUnitJob;
    

    @Test
    public void test02getByPkey() {
        String period = "108年1-9月";
        Integer rank = Integer.valueOf(1);
        NonBusinessUnit entity = nonBusinessUnitService.getByPkey(period, rank);
        System.out.println(entity);
    }
    
    @Test
    public void test01create() {
        NonBusinessUnit entity = new NonBusinessUnit("108年1-9月", Integer.valueOf(1), "中國大陸", Long.valueOf(3349023888L),
        		Float.valueOf(23.87F), "");
        int row = nonBusinessUnitService.create(entity);
        System.out.println("row = " + row);
        
        entity = new NonBusinessUnit("108年10-12月", Integer.valueOf(1), "法國", Long.valueOf(987654L),
        		Float.valueOf(12.22F), "");
        row = nonBusinessUnitService.create(entity);
        System.out.println("row = " + row);
    }
    
    @Test
    public void test03update() {
        String period = "108年1-9月";
        Integer rank = Integer.valueOf(1);
        NonBusinessUnit entity = nonBusinessUnitService.getByPkey(period, rank);
        entity.setCountry("琉球");
        entity.setAmt(Long.valueOf(123456789L));
        entity.setPercentage(Float.valueOf(10.2F));
        entity.setComments("更名");
        int row = nonBusinessUnitService.update(entity);
        System.out.println("row = " + row);
    }
    
    @Test
    public void test04delete() {
        String period = "108年1-9月";
        Integer rank = Integer.valueOf(1);
        int row = nonBusinessUnitService.delete(period, rank);
        System.out.println("row = " + row);
    }
    
    @Test
    public void test05importNoBatch()  {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    NonBusinessUnitTest.class.getResourceAsStream(path), "UTF-8"));
            String line = null;
            int row = 0;
            // 跳過前2列
            line = reader.readLine();
            // line = reader.readLine();
            long begin = System.currentTimeMillis();
            while ((line = reader.readLine()) != null) {
                String[] rows = line.split(",");
                try {
                	String row5;
                	if(rows.length == 5) {
                		row5 = "";
                	} else {
                		row5 = rows[5];
                	}
                    NonBusinessUnit entity = new NonBusinessUnit(rows[0], Integer.valueOf(rows[1]), rows[2],
                            Long.valueOf(rows[3]), Float.valueOf(rows[4]), row5);
                    row += nonBusinessUnitDao.create(entity);
                } catch (Exception ex) {
                    System.out.println(line);
                    ex.printStackTrace();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("spend :" + (end-begin));
            System.out.println("row = " + row);
            reader.close();
        } catch (Exception ex) {
            LogUtil.error(ex, ex);
        }
    }
    
    
    @Test
    public void test05WithSpringBatch() {
        try {
            long begin = System.currentTimeMillis();
            Map<String,JobParameter> parameters = new HashMap<String,JobParameter>();
            parameters.put("timestamp", new JobParameter(Long.valueOf(System.currentTimeMillis() / 1000)));
            JobExecution jobExecution = jobLauncher.run(nonBusinessUnitJob, new JobParameters(parameters));
            long end = System.currentTimeMillis();
            System.out.println("spend :" + (end-begin));
            System.out.println(jobExecution);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void test06listCondition() {
        Map<String, Object> query = new HashMap<String, Object>();
        query.put("country", "中國大陸");
        // query.put("period", "108年1-9月");
        List<NonBusinessUnit> entitys = nonBusinessUnitService.listByCondition(query);
        System.out.println("size = " + entitys.size());
        for(NonBusinessUnit entity : entitys) {
        	System.out.println(entity);
        }
    }

}
