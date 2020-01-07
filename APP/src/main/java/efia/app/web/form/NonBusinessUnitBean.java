package efia.app.web.form;

import efia.app.entity.NonBusinessUnit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="貿易統計")
public class NonBusinessUnitBean {
    
    @ApiModelProperty(dataType="string", value="貿易統計日期區間", required=true)
    private String period;
    
    @ApiModelProperty(dataType="string", value="排名", required=true)
    private String rank;
    
    @ApiModelProperty(dataType="string", value="國家", required=false// ,
            //allowableValues="基隆市,臺北市,新北市,桃園市,新竹市,新竹縣,苗栗縣,臺中市,彰化縣,南投縣,雲林縣,嘉義市,嘉義縣,臺南市,高雄市,屏東縣,宜蘭縣,花蓮縣,臺東縣,澎湖縣,金門縣,連江縣")
    		)
    private String country;
    
    @ApiModelProperty(dataType="string", value="貿易總值（新臺幣千元）")
    private String amt;
    
    @ApiModelProperty(dataType="string", value="百分比")
    private String percentage;
    
    @ApiModelProperty(dataType="string", value="備註")
    private String comments;

    public NonBusinessUnitBean() {
        super();
    }
    
    public NonBusinessUnitBean(NonBusinessUnit entity) {
        super();
        this.period = entity.getPeriod();
        this.rank = entity.getRank().toString();
        this.country = entity.getCountry();
        this.amt = entity.getAmt().toString();
        this.percentage = entity.getPercentage().toString();
        this.comments = entity.getComments();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
		this.comments = comments;
    }
    
    public NonBusinessUnit toEntity() {
        return new NonBusinessUnit(this.period, Integer.valueOf(this.rank), this.country,
                Long.valueOf(this.amt), Float.valueOf(this.percentage), this.comments);
    }

}
