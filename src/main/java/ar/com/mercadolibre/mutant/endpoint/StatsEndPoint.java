package ar.com.mercadolibre.mutant.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.mercadolibre.mutant.dto.StatsDTO;
import ar.com.mercadolibre.mutant.service.StatsServiceImpl;

@Controller
public class StatsEndPoint {

	
	@Autowired
	private StatsServiceImpl statsService;
	
	
	
	@GetMapping("/stats")
	@ResponseBody
	public StatsDTO getStats() {
		return statsService.getStats();
	}
	
}
