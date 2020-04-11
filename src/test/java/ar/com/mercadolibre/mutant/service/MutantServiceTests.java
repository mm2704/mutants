package ar.com.mercadolibre.mutant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.mercadolibre.mutant.dao.DnaDao;
import ar.com.mercadolibre.mutant.dto.DnaDTO;
import ar.com.mercadolibre.mutant.helper.MutantHelper;
import ar.com.mercadolibre.mutant.searchers.MutantSearcherImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MutantServiceTests {

	@InjectMocks
	private MutantService mutantService = new MutantServiceImpl();
	
	@Mock
	private MutantSearcherImpl mutantSearcher;
	
	@Mock
	private DnaDao dnaDao;
	
	@Mock
	private MutantHelper helper;
	
	private String[] dnaMutant =  new String[] { "ATGCGA","CAGTGC","TTATGT","AAAAGG","CCCCTA","TTTTTT" };
	private String[] dnaHuman =  new String[] {  "ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCT", "TCACGC" };
	
	private DnaDTO dnaDTONoMutant = new DnaDTO(); 
	private DnaDTO dnaDTOMutant = new DnaDTO();
	
	@Before
	public void setup() {
		dnaDTONoMutant = setDnaDto(dnaHuman, false);
		dnaDTOMutant = setDnaDto(dnaMutant, true);
		Mockito.when(mutantSearcher.searchMutant(dnaDTOMutant)).thenReturn(dnaDTOMutant);
		Mockito.when(mutantSearcher.searchMutant(dnaDTONoMutant)).thenReturn(dnaDTONoMutant);
	}
	
	@Test
	public void isMutantTest() {
		assertEquals(dnaDTOMutant.getDna(), mutantService.isMutant(dnaDTOMutant).getDna());
		assertEquals(dnaDTONoMutant.getDna(), mutantService.isMutant(dnaDTONoMutant).getDna());
	}
	
	private DnaDTO setDnaDto(String[] dnaChain, boolean bool) {
		DnaDTO dna = new DnaDTO();
		dna.setDna(dnaChain);
		dna.setMutant(bool);
		return dna;
	}
}
