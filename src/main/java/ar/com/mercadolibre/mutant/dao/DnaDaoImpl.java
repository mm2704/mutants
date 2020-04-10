package ar.com.mercadolibre.mutant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import ar.com.mercadolibre.mutant.model.Count;
import ar.com.mercadolibre.mutant.model.Dna;

@Component
public class DnaDaoImpl implements DnaDao {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	@Override
    public void save(Dna dna) {
        dynamoDBMapper.save(dna);
    }
	
	@Override
	public boolean exist(String dnaId) {
		Dna result = dynamoDBMapper.load(Dna.class ,dnaId);
		return result != null;
	}

	private void createNewCount(String type) {
		Count newCount = new Count();
		newCount.setCountId(type);
		newCount.setCountNumber(1);
		dynamoDBMapper.save(newCount);
	}
	
	/**
	 * Si los rows no exiten en la base, los crea con contador 1, sino los updatea
	 */
	@Override
	public void updateOrCreateCount(String type) {
		Count result = dynamoDBMapper.load(Count.class , type);
		if(result != null) {
			updateCount(result);
		} else {
			createNewCount(type);
		}		
	}

	/**
	 * Update al cantidad de humanos o mutantes en la base de datos
	 * @param result
	 */
	private void updateCount(Count result) {
		result.setCountId(result.getCountId());
		result.setCountNumber(result.getCountNumber() +1);
		dynamoDBMapper.save(result);
	}
	
	@Override
	public Count getCount(String type) {
		Count result = dynamoDBMapper.load(Count.class , type);
		if(result == null) {
			Count resultEmpty = new Count();
			resultEmpty.setCountId(type);
			resultEmpty.setCountNumber(0);
			return resultEmpty;
		}
		return result;
	} 	
}
