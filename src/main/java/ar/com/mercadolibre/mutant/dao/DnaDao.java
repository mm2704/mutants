package ar.com.mercadolibre.mutant.dao;

import ar.com.mercadolibre.mutant.model.Count;
import ar.com.mercadolibre.mutant.model.Dna;

public interface DnaDao {

	void save(Dna dna);

	boolean exist(String dnaId);

	Count getCount(String type);

	void updateOrCreateCount(String type);
}
