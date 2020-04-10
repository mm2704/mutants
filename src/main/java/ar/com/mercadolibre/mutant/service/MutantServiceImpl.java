package ar.com.mercadolibre.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mercadolibre.model.Human;
import ar.com.mercadolibre.model.Mutant;
import ar.com.mercadolibre.mutant.dao.DnaDao;
import ar.com.mercadolibre.mutant.dto.DnaDTO;
import ar.com.mercadolibre.mutant.searchers.MutantSearcher;

@Service
public class MutantServiceImpl implements MutantService {

	@Autowired
	private MutantSearcher mutantSearcher;
	
	@Autowired
	private DnaDao dnaDao;
	
	
	/**
	 * Revisa si el adn es mutante y llama al dao para guardarlo en la base de datos
	 */
	public DnaDTO isMutant(DnaDTO dnaDto) {
		DnaDTO result = mutantSearcher.searchMutant(dnaDto);
		
		if(result.isMutant()) {
			Mutant mutant = new Mutant();
			mutant.setDnaId(String.join(".",result.getDna()));
			dnaDao.save(mutant);
		} else {
			Human human = new Human();
			human.setDnaId(String.join(".",result.getDna()));
			dnaDao.save(human);
		}
		return result;
	}
}
