package efia.app.batch;

import org.springframework.batch.item.ItemProcessor;

import efia.app.entity.NonBusinessUnit;

public class NonBusinessUnitProcessor implements ItemProcessor<NonBusinessUnit, NonBusinessUnit> {

	public NonBusinessUnit process(NonBusinessUnit itemObj) throws Exception {
		return itemObj;
	}
}