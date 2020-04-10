package ar.com.mercadolibre.mutant.dao;

import ar.com.mercadolibre.mutant.model.Dna;

public interface DnaDao {

	void save(Dna dna);

	Integer getCountOf(String bioType);
}
