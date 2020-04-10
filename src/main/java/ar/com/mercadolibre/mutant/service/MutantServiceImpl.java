package ar.com.mercadolibre.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.mercadolibre.mutant.dao.DnaDao;
import ar.com.mercadolibre.mutant.dto.DnaDTO;
import ar.com.mercadolibre.mutant.helper.MutantHelper;
import ar.com.mercadolibre.mutant.model.Dna;
import ar.com.mercadolibre.mutant.searchers.MutantSearcher;

@Service
public class MutantServiceImpl implements MutantService {

	@Autowired
	private MutantSearcher mutantSearcher;
	
	@Autowired
	private DnaDao dnaDao;
	
	@Autowired
	private MutantHelper helper;
	
	/**
	 * Revisa si el adn es mutante y llama al dao para guardarlo en la base de datos
	 */
	@Override
	@Transactional
	public DnaDTO isMutant(DnaDTO dnaDto) {
		DnaDTO result = mutantSearcher.searchMutant(dnaDto);
		String dnaId = String.join(".",result.getDna());
		if(!dnaDao.exist(dnaId)) {
			Dna dna = new Dna();
			dna.setDnaId(dnaId);
			dna.setMutant(result.isMutant());
			dnaDao.save(dna);
			dnaDao.updateOrCreateCount(helper.getType(dnaDto));
		}
			
		return result;
	}

}
