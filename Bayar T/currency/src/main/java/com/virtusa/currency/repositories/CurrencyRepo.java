package com.virtusa.currency.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.currency.models.Currency;

public interface CurrencyRepo extends JpaRepository<Currency, Long>{

}
