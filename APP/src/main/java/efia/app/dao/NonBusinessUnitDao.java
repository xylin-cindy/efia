package efia.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import efia.app.entity.NonBusinessUnit;


public interface NonBusinessUnitDao {
    
    NonBusinessUnit getByPkey(@Param("period") String period, @Param("rank") Integer rank);
    
    int create(NonBusinessUnit entity);
    
    int update(NonBusinessUnit entity);
    
    int delete(@Param("period") String period, @Param("rank") Integer rank);
    
    int countAll();
    
    List<NonBusinessUnit> listAll();
    
    int countByCondition(Map<String, Object> map);
    
    List<NonBusinessUnit> listByCondition(Map<String, Object> map);
    
    int createW(NonBusinessUnit entity);
    
    int createFromTemp();
    
    int deleteAll();
    
    int deleteWAll();
    
}
