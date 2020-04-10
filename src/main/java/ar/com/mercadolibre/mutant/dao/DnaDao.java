package ar.com.mercadolibre.mutant.dao;

import ar.com.mercadolibre.model.Human;
import ar.com.mercadolibre.model.Mutant;

public interface DnaDao {

	void save(Human human);
	
	void save(Mutant mutant);
	
//	List<Dna> getAll();
}
