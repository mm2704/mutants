package ar.com.mercadolibre.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mercadolibre.mutant.dao.DnaDao;
import ar.com.mercadolibre.mutant.dto.StatsDTO;
import ar.com.mercadolibre.mutant.enums.TypesEnum;
import ar.com.mercadolibre.mutant.helper.MutantHelper;
import ar.com.mercadolibre.mutant.model.Count;

@Service
public class StatsServiceImpl implements StatsService {

	
	@Autowired
	private DnaDao dnaDao;

	@Autowired
	private MutantHelper helper;
	
	@Override
	public StatsDTO getStats() {

		Count countMutants = dnaDao.getCount(TypesEnum.MUTANT.getValue());
		Count countHumans = dnaDao.getCount(TypesEnum.HUMAN.getValue());
		StatsDTO stats = helper.getStats(countMutants.getCountNumber(), countHumans.getCountNumber());
		return stats;
	}



	
	
}
