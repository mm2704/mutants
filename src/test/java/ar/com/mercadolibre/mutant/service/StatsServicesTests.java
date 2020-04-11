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
import ar.com.mercadolibre.mutant.dto.StatsDTO;
import ar.com.mercadolibre.mutant.helper.MutantHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatsServicesTests {

	@InjectMocks
	private StatsService statsService = new StatsServiceImpl();
	
	@Mock
	private DnaDao dnaDao;

	@Mock
	private MutantHelper helper = new MutantHelper();

	private StatsDTO noMutantsStats = setStats(0, 2);
	private StatsDTO mutantsAndHumans = setStats(5, 5);
	private StatsDTO noHumans = setStats(2, 0);
	
	@Before
	public void setup() {
		noMutantsStats = setStats(0, 2);
		mutantsAndHumans = setStats(5, 5);
		noHumans = setStats(2, 0);
	}
	
	@Test
	public void getCountOfMutantsAndsHumansTests() {
		Mockito.when(statsService.getStats()).thenReturn(mutantsAndHumans);
		assertEquals(statsService.getStats().getCountHumanDna(), 5);
		assertEquals(statsService.getStats().getCountMutantDna(), 5);
		assertEquals(statsService.getStats().getRatio(), 1);
	}
	
	@Test
	public void getCountOfMutantsAndsNoHumansTests() {
		Mockito.when(statsService.getStats()).thenReturn(noHumans);
		assertEquals(statsService.getStats().getCountHumanDna(), 0);
		assertEquals(statsService.getStats().getCountMutantDna(), 2);
		assertEquals(statsService.getStats().getRatio(), 2);
	}
	
	@Test
	public void getCountOfNoMutantsAndsHumansTests() {
		Mockito.when(statsService.getStats()).thenReturn(noMutantsStats);
		assertEquals(statsService.getStats().getCountHumanDna(), 2);
		assertEquals(statsService.getStats().getCountMutantDna(), 0);
		assertEquals(statsService.getStats().getRatio(), 0);
	}
	
	private StatsDTO setStats(Integer mutants, Integer humans) {
		MutantHelper mutantHelper = new MutantHelper();
		StatsDTO stats = mutantHelper.getStats(mutants, humans);
		return stats;
	}
	
	
}
