package com.virtusa.traderapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraderInput {
	private long tradingLimit;
	private String email;
	private String dob;
	private Bank bank;
}
