package ar.com.mercadolibre.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mercadolibre.mutant.dao.DnaDao;
import ar.com.mercadolibre.mutant.dto.StatsDTO;
import ar.com.mercadolibre.mutant.enums.TypesEnum;
import ar.com.mercadolibre.mutant.helper.MutantHelper;

@Service
public class StatsServiceImpl implements StatsService {

	
	@Autowired
	private DnaDao dnaDao;

	@Autowired
	private MutantHelper helper;
	
	@Override
	/**
	 * Devuelve la cantidad de humanos y mutantes.
	 */
	public StatsDTO getStats() {

		
		Integer countHumans = dnaDao.getCountOf(TypesEnum.HUMAN.getValue());
		Integer countMutants = dnaDao.getCountOf(TypesEnum.MUTANT.getValue());
		StatsDTO stats = helper.getStats(countMutants, countHumans);
		return stats;
	}



	
	
}
