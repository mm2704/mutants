package ar.com.mercadolibre.mutant.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import ar.com.mercadolibre.model.Dna;
import ar.com.mercadolibre.mutant.dto.DnaDTO;

public class DnaDaoImpl implements DnaDao {

	 private DynamoDBMapper dynamoDBMapper;
	

    public DnaDTO save(DnaDTO dnaDTO) {
    	Dna dna = new Dna();
    	dna.setDnaId(dnaDTO.getDna());
    	dna.setMutant(dnaDTO.isMutant());
        dynamoDBMapper.save(dna);
        return dnaDTO;
    }

}
