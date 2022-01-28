package com.virtusa.traderapi.mutations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.models.TraderInput;
import com.virtusa.traderapi.services.TraderService;

@Component
public class TraderMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private TraderService traderService;
	
	public Trader createTrader(TraderInput traderInput) {
		Trader trader = new Trader();
		trader.setTradingLimit(traderInput.getTradingLimit());
		trader.setEmail(traderInput.getEmail());
		trader.setDob(traderInput.getDob());
		return this.traderService.addTrader(0, trader);
	}
	
	public List<Trader> updateBank(long bankId) {
		return this.traderService.updateBank(bankId);
	}
}
