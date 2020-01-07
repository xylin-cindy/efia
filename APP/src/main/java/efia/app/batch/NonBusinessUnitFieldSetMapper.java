package efia.app.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import efia.app.entity.NonBusinessUnit;

public class NonBusinessUnitFieldSetMapper implements FieldSetMapper<NonBusinessUnit> {

	public NonBusinessUnit mapFieldSet(FieldSet fieldSetObj) throws BindException {
	    NonBusinessUnit obj = new NonBusinessUnit();
		obj.setPeriod(fieldSetObj.readString(0));
		obj.setRank(Integer.valueOf(fieldSetObj.readString(1)));
		obj.setCountry(fieldSetObj.readString(2));
		obj.setAmt(Long.valueOf(fieldSetObj.readString(3)));
		obj.setPercentage(Float.valueOf(fieldSetObj.readString(4)));
		obj.setComments(fieldSetObj.readString(5));
		return obj;
	    
	}
}