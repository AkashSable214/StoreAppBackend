package com.cjc.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.entity.Dealer;
import com.cjc.app.repo.DealerRepo;

@Service
public class DealerServiceIMPL implements DealerService {

	  @Autowired
	    private DealerRepo repo;

	    @Override
	    public Dealer saveDealer(Dealer dealer) {
	        return repo.save(dealer);
	    }

	    @Override
	    public List<Dealer> getAllDealer() {
	        return repo.findAll();
	    }

	    @Override
	    public Dealer getDealerById(Long id) {
	        return repo.findById(id).orElse(null);
	    }

	    @Override
	    public Dealer updateDealer(Long id, Dealer dealer) {
	        dealer.setId(id);
	        return repo.save(dealer);
	    }

	    @Override
	    public void deleteDealer(Long id) {
	        repo.deleteById(id);
	    }
	    
	    @Override
	    public long countDealers() {
	        return repo.count();
	    }
	    
	    @Override
	    public List<Map<String, Object>> getDealerSummary() {
	        List<Map<String, Object>> summary = new ArrayList<>();

	        for (Dealer dealer : repo.findAll()) {
	            Map<String, Object> dealerInfo = new HashMap<>();
	            dealerInfo.put("dealerName", dealer.getDealerName());

	            int productCount = 0;
	            if (dealer.getProducts() != null) {
	                productCount = dealer.getProducts().size();
	            }
	            dealerInfo.put("totalProducts", productCount);

	            summary.add(dealerInfo);
	        }

	        return summary;
	    }

	}
	