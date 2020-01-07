package efia.app.web.controller;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import efia.app.entity.NonBusinessUnit;
import efia.app.service.NonBusinessUnitService;
import efia.app.web.form.NonBusinessUnitBean;
import efia.app.web.form.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(tags="貿易統計API")
@RequestMapping("/nonBusinessUnit")
public class NonBusinessUnitController {
    
    // private static final Logger logger = Logger.getLogger(NonBusinessUnitController.class);
    
    @Autowired
    private NonBusinessUnitService nonBusinessUnitService;
    
    @ApiResponses(value={
            @ApiResponse(code=500, message="查詢異常"),
            @ApiResponse(code=200, message="查詢成功"),
    })
    @ApiOperation(value="依據日期區間、名次取得貿易統計資料")
    @RequestMapping(value = "/{period}/{rank}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<NonBusinessUnitBean> getByPkey(
            @ApiParam(value="日期區間", required=true) @PathVariable String period, 
            @ApiParam(value="排名", required=true) @PathVariable String rank) throws Exception{
    	// period = period.getBytes("Utf8").toString();
	    NonBusinessUnit entity = nonBusinessUnitService.getByPkey(period, Integer.valueOf(rank));
        if (entity != null) {
            return ResponseEntity.ok(new NonBusinessUnitBean(entity));
        }
        return ResponseEntity.status(500).build();
    }
    
    
    @ApiResponses(value={
            @ApiResponse(code=500, message="查詢異常"),
            @ApiResponse(code=200, message="查詢成功"),
    })
    @ApiOperation(value="依分頁大小日期區間、名次取得貿易統計資料")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NonBusinessUnitBean>> listAll(PageBean pageBean) {
        Map<String, Object> query = getQuery(null, null, pageBean);
        List<NonBusinessUnit> entitys = nonBusinessUnitService.listByCondition(query);
        if (entitys != null && entitys.size() > 0) {
            List<NonBusinessUnitBean> entityBeans = new ArrayList<NonBusinessUnitBean>();
            for (NonBusinessUnit entity : entitys) {
                entityBeans.add(new NonBusinessUnitBean(entity));
            }
            return ResponseEntity.ok(entityBeans);
        }
        return ResponseEntity.status(500).build();
    }
    
    
/*    @ApiResponses(value={
            @ApiResponse(code=500, message="查詢異常"),
            @ApiResponse(code=200, message="查詢成功"),
    })
    @ApiOperation(value="依查詢條件取得統一編號查詢非營利事業單位資料")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NonBusinessUnitBean>> listByCondition(
            @ApiParam(value="非營利事業單位統一編號", required=false) @RequestParam(required=false) String ban,
            @ApiParam(value="縣市名稱", required=false, allowableValues="基隆市,臺北市,新北市,桃園市,新竹市,新竹縣,苗栗縣,臺中市,彰化縣,南投縣,雲林縣,嘉義市,嘉義縣,臺南市,高雄市,屏東縣,宜蘭縣,花蓮縣,臺東縣,澎湖縣,金門縣,連江縣")
            @RequestParam(required=false) String hsnNm,
            PageBean pageBean
            ) {
        Map<String, Object> query = getQuery(ban, hsnNm, pageBean);
        List<NonBusinessUnit> entitys = nonBusinessUnitService.listByCondition(query);
        if (entitys == null || entitys.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        List<NonBusinessUnitBean> entityBeans = new ArrayList<NonBusinessUnitBean>();
        for (NonBusinessUnit entity : entitys) {
            entityBeans.add(new NonBusinessUnitBean(entity));
        }
        return ResponseEntity.ok(entityBeans);
    }*/
     
    @ApiResponses(value={
            @ApiResponse(code=500, message="查詢異常"),
            @ApiResponse(code=200, message="查詢成功"),
    })
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="period", value="日期區間", dataType="String", required=false, paramType="query"),
            @ApiImplicitParam(name="country", value="國家", dataType="String", required=false, paramType="query")//, , allowableValues="基隆市,臺北市,新北市,桃園市,新竹市,新竹縣,苗栗縣,臺中市,彰化縣,南投縣,雲林縣,嘉義市,嘉義縣,臺南市,高雄市,屏東縣,宜蘭縣,花蓮縣,臺東縣,澎湖縣,金門縣,連江縣"),
    })
    @ApiOperation(value="依查詢條件取得日期區間、國家查詢貿易統計資料")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NonBusinessUnitBean>> listByCondition(String period, String country,
            PageBean pageBean) {
        Map<String, Object> query = getQuery(period, country, pageBean);
        List<NonBusinessUnit> entitys = nonBusinessUnitService.listByCondition(query);
        if (entitys != null && entitys.size() > 0) {
            List<NonBusinessUnitBean> entityBeans = new ArrayList<NonBusinessUnitBean>();
            for (NonBusinessUnit entity : entitys) {
                entityBeans.add(new NonBusinessUnitBean(entity));
            }
            return ResponseEntity.ok(entityBeans);
        }
        return ResponseEntity.status(500).build();
    }
    
    @ApiResponses(value={
            @ApiResponse(code=500, message="新增失敗"),
            @ApiResponse(code=200, message="新增成功"),
    })
    @ApiOperation(value="新增貿易統計日期區間、名次")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<NonBusinessUnitBean> create(NonBusinessUnitBean bean) {
        if (nonBusinessUnitService.getByPkey(bean.getPeriod(), Integer.valueOf(bean.getRank())) == null) {
            int row = nonBusinessUnitService.create(bean.toEntity());
            if (row == 1) {
                return ResponseEntity.ok(bean);
            }
        }    
        return ResponseEntity.status(500).build();
    }
    
    
    @ApiResponses(value={
            @ApiResponse(code=500, message="更新失敗"),
            @ApiResponse(code=200, message="更新成功"),
    })
    @ApiImplicitParams(value={
    		@ApiImplicitParam(name="period", value="期間", dataType="String", required=true, paramType="path"),
            @ApiImplicitParam(name="rank", value="排名", dataType="String", required=true, paramType="path"),
            @ApiImplicitParam(name="country", value="國家", dataType="String", required=false, paramType="query"),// , allowableValues="基隆市,臺北市,新北市,桃園市,新竹市,新竹縣,苗栗縣,臺中市,彰化縣,南投縣,雲林縣,嘉義市,嘉義縣,臺南市,高雄市,屏東縣,宜蘭縣,花蓮縣,臺東縣,澎湖縣,金門縣,連江縣"),
            @ApiImplicitParam(name="amt", value="貿易總值（新臺幣千元）", dataType="String", required=false, paramType="query"),
            @ApiImplicitParam(name="percentage", value="百分比", dataType="String", required=false, paramType="query"),
            @ApiImplicitParam(name="comments", value="備註", dataType="String", required=false, paramType="query")
    })
    @ApiOperation(value="更新貿易統計日期區間、排名資訊")
    @RequestMapping(value = "/{period}/{rank}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<NonBusinessUnitBean> update(@PathVariable String period, @PathVariable String rank, String country,
            String amt, String percentage, String comments) {
        NonBusinessUnit entity = nonBusinessUnitService.getByPkey(period, Integer.valueOf(rank));
        if (entity != null) {
            if (StringUtils.isNotBlank(country)) {
                entity.setCountry(country.trim());
            }
            if (StringUtils.isNotBlank(amt)) {
                entity.setAmt(Long.valueOf(amt.trim()));
            }
            if (StringUtils.isNotBlank(percentage)) {
                entity.setPercentage(Float.valueOf(percentage.trim()));
            }
            if (StringUtils.isNotBlank(comments)) {
                entity.setComments(comments.trim());
            }    
            int row = nonBusinessUnitService.update(entity);
            if (row == 1) {
                return ResponseEntity.ok(new NonBusinessUnitBean(entity));
            }
        }
        return ResponseEntity.status(500).build();
    }    
    
    @ApiResponses(value={
            @ApiResponse(code=500, message="刪除失敗"),
            @ApiResponse(code=200, message="刪除成功"),
    })
    @ApiOperation(value="刪除貿易統計日期區間、排名資訊")
    @RequestMapping(value = "/{period}/{rank}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> delete(
            @ApiParam(value="貿易統計日期區間", required=true) @PathVariable String period, 
            @ApiParam(value="排名", required=true) @PathVariable String rank) {
        int row = nonBusinessUnitService.delete(period, Integer.valueOf(rank));
        if (row == 1) {
            return ResponseEntity.ok("Delete Successful");
        }
        return ResponseEntity.status(500).build();
    }
    
    private Map<String, Object> getQuery(String period, String country, PageBean pageBean) {
        Map<String, Object> query = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(period)) {
            query.put(NonBusinessUnit.PARAM_PERIOD, period.trim());
        }
        if (StringUtils.isNotBlank(country)) {
            query.put(NonBusinessUnit.PARAM_COUNTRY, country.trim());
        }
        if (pageBean.getLimit() != null && (pageBean.getLimit() < 0 || pageBean.getLimit() > PageBean.DEFAULT_LIMIT)) {
            pageBean.setLimit(PageBean.DEFAULT_LIMIT);
        }
        query.put(PageBean.PARAM_LIMIT, pageBean.getLimit());
        if (pageBean.getOffset() == null || pageBean.getOffset() < 0) {
            pageBean.setOffset(PageBean.DEFAULT_OFFSET);
        }
        query.put(PageBean.PARAM_OFFSET, pageBean.getOffset());
        return query;
    }
    
    
}
