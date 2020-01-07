package efia.app.service;

import java.util.List;
import java.util.Map;

import efia.app.entity.NonBusinessUnit;

public interface NonBusinessUnitService {
    
    NonBusinessUnit getByPkey(String period, Integer rank);
    
    int create(NonBusinessUnit entity);
    
    int update(NonBusinessUnit entity);
    
    int delete(String period, Integer rank);

    int countByCondition(Map<String, Object> query);
    
    List<NonBusinessUnit> listByCondition(Map<String, Object> query);
    
    // int reset();
    
}
