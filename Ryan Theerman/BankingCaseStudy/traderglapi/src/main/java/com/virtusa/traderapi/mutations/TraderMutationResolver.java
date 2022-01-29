package com.virtusa.traderapi.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.traderapi.models.*;
import com.virtusa.traderapi.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TraderMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private TraderService traderService;

	public Trader createTrader(TraderInput traderInput) {

		return this.traderService.addTrader(traderInput.getTraderId(),
				new Trader(0,new FullName(traderInput.getName().getFirstName(),traderInput.getName().getLastName(),
						traderInput.getName().getMiddleName()),traderInput.getTradingLimit(),
						traderInput.getEmail(),LocalDate.parse(traderInput.getDob()),new Bank()));
		}

	public Trader updateTrader(long traderId, String email) {
		return this.traderService.updateTrader(traderId, email);
	}

	public Boolean deleteTrader(Long traderId) {
		return this.traderService.deleteTraderById(traderId);
	}
}
