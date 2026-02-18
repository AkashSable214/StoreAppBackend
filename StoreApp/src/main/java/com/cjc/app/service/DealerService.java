package com.cjc.app.service;

import java.util.List;
import java.util.Map;

import com.cjc.app.entity.Dealer;

public interface DealerService {

	Dealer saveDealer(Dealer dealer);

	List<Dealer> getAllDealer();

	Dealer getDealerById(Long id);

	Dealer updateDealer(Long id, Dealer dealer);

	void deleteDealer(Long id);

	public long countDealers();
	
	List<Map<String, Object>> getDealerSummary();


}
