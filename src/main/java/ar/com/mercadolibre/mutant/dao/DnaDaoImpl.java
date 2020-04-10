package ar.com.mercadolibre.mutant.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

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
	public Integer getCountOf(String bioType) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(bioType));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
            .withFilterExpression("BioType = :val1").withExpressionAttributeValues(eav);

        Integer result = dynamoDBMapper.count(Dna.class, scanExpression);
        return result;
	}
	
}
