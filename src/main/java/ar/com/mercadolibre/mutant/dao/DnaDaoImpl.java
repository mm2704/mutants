package ar.com.mercadolibre.mutant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import ar.com.mercadolibre.model.Human;
import ar.com.mercadolibre.model.Mutant;

@Component
public class DnaDaoImpl implements DnaDao {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	

    public void save(Human human) {
        dynamoDBMapper.save(human);
    }

    public void save(Mutant mutant) {
        dynamoDBMapper.save(mutant);
    }
    

//	@Override
//	public List<Dna> getAll() {
//		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
//		// Change to your model class   
//		List<Dna> scanResult = dynamoDBMapper.scan(Dna.class, scanExpression);
//		return scanResult;
//
//	}

}
