package com.virtusa.currencyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.currencyapi.models.Currency;

public interface CurrencyRepo extends JpaRepository<Currency,Long>{

}
