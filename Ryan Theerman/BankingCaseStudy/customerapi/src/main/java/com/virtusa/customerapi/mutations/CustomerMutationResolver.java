package com.virtusa.customerapi.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.models.CustomerInput;
import com.virtusa.customerapi.models.FullName;
import com.virtusa.customerapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CustomerService customerService;
	
	public Customer createCustomer(CustomerInput customerInput) {
		return this.customerService.addCustomer(new Customer(
				customerInput.getCustomerName(),
				customerInput.getCustomerAddress(),
				customerInput.getCustomerCountry(),
				customerInput.getCustomerZip(),
				customerInput.getCustomerState(),
				customerInput.getCustomerPhone(),
				customerInput.getCustomerEmail(),
				customerInput.getDob()));
	}

	public Customer updateCustomer(long customerId,
								   FullName customerName,
								   String customerAddress,
								   String customerCountry,
								   String customerZip,
								   String customerState,
								   String customerPhone,
								   String customerEmail,
								   String dob) {
		return this.customerService.updateCustomer(customerId,
				customerName,
				customerAddress,
				customerCountry,
				customerZip,
				customerState,
				customerPhone,
				customerEmail,
				dob);
	}

	public Boolean deleteCustomer(Long customerId) {
		return this.customerService.deleteCustomerById(customerId);
	}

}
