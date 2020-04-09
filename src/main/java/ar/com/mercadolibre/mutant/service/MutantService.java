package ar.com.mercadolibre.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mercadolibre.mutant.model.DnaDTO;
import ar.com.mercadolibre.mutant.searchers.MutantSearcher;

@Service
public class MutantService {

	@Autowired
	private MutantSearcher mutantSearcher;
	
	
	
	public boolean isMutant(DnaDTO dnaDto) {
		return mutantSearcher.searchMutant(dnaDto);
	}

	
	
}
