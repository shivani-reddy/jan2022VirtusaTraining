package com.virtusa.currencyapi.repositories;
import com.virtusa.currencyapi.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyRepo extends JpaRepository<Currency,Long > {

}
