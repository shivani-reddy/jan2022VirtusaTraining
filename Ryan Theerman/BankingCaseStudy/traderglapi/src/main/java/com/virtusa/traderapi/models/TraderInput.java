package com.virtusa.traderapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraderInput {

    private long traderId;
    private FullName name;
    private long tradingLimit;
    private String email;
    private String dob;
    private BankTraderInput bank;
}
