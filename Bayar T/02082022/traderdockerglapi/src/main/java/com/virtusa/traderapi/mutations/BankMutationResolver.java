package com.virtusa.traderapi.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.models.BankInput;
import com.virtusa.traderapi.services.BankService;

@Component
public class BankMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private BankService bankService;
	
	public Bank createBank(BankInput bankInput) {
		return this.bankService.addBank(new Bank(0,bankInput.getBankName(),bankInput.getAddress()));
	}
	
	public Bank updateBank(long bankId,String address) {
		return this.bankService.updateBank(bankId, address);
	}

}
