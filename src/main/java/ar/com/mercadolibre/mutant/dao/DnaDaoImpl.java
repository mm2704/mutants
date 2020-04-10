package ar.com.mercadolibre.mutant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import ar.com.mercadolibre.model.Dna;
import ar.com.mercadolibre.mutant.dto.DnaDTO;

@Component
public class DnaDaoImpl implements DnaDao {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	

    public DnaDTO save(DnaDTO dnaDTO) {
    	Dna dna = new Dna();
    	dna.setDnaId(String.join(".", dnaDTO.getDna()));
    	dna.setMutant(dnaDTO.isMutant());
        dynamoDBMapper.save(dna);
        return dnaDTO;
    }

}
