package efia.app.entity;

public class NonBusinessUnit  {
    
    public static final String PARAM_PERIOD = "period";
    
    public static final String PARAM_COUNTRY = "country";

    private String period;
    
    private Integer rank;
    
    private String country;
    
    private Long amt;
    
    private Float percentage;
    
    private String comments;
    

    public NonBusinessUnit() {
        super();
    }

    public NonBusinessUnit(String period, Integer rank, String country, Long amt, Float percentage,
            String comments) {
        super();
        this.period = period;
        this.rank = rank;
        this.country = country;
        this.amt = amt;
        this.percentage = percentage;
        this.comments = comments;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getAmt() {
        return amt;
    }

    public void setAmt(Long amt) {
        this.amt = amt;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "NonBusinessUnit [period=" + period + ", rank=" + rank + ", country=" + country + ", amt=" + amt
                + ", percentage=" + percentage + ", comments=" + comments + "]";
    }
    
}


/*
package efia.app.entity;

import java.util.Date;

public class NonBusinessUnit  {
    
    public static final String PARAM_BAN = "ban";
    
    public static final String PARAM_HSN_NM = "hsnNm";

    private String ban;
    
    private String unitNm;
    
    private String hsnNm;
    
    private String modifyDate;
    
    private String modifyCd;
    
    private String modifyReason;
    
    private Date createTime;
    
    private Date updateTime;
    

    public NonBusinessUnit() {
        super();
    }

    public NonBusinessUnit(String ban, String unitNm, String hsnNm, String modifyDate, String modifyCd,
            String modifyReason) {
        super();
        this.ban = ban;
        this.unitNm = unitNm;
        this.hsnNm = hsnNm;
        this.modifyDate = modifyDate;
        this.modifyCd = modifyCd;
        this.modifyReason = modifyReason;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public String getUnitNm() {
        return unitNm;
    }

    public void setUnitNm(String unitNm) {
        this.unitNm = unitNm;
    }

    public String getHsnNm() {
        return hsnNm;
    }

    public void setHsnNm(String hsnNm) {
        this.hsnNm = hsnNm;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyCd() {
        return modifyCd;
    }

    public void setModifyCd(String modifyCd) {
        this.modifyCd = modifyCd;
    }

    public String getModifyReason() {
        return modifyReason;
    }

    public void setModifyReason(String modifyReason) {
        this.modifyReason = modifyReason;
    }
    
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "NonBusinessUnit [ban=" + ban + ", unitNm=" + unitNm + ", hsnNm=" + hsnNm + ", modifyDate=" + modifyDate
                + ", modifyCd=" + modifyCd + ", modifyReason=" + modifyReason + "]";
    }
    
}
*/