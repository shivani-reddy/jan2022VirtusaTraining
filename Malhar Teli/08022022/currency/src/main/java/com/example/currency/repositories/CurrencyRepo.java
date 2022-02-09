package com.example.currency.repositories;

import com.example.currency.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long> {

    @Query("select currency from Currency currency where currency.currencyCode=:currencyCode")
    public Currency findCurrencyByCode(@Param("currencyCode") String currencyCode);

    @Query("delete from Currency currency where currency.currencyCode=:currencyCode")
    public void deleteById(@Param("currencyCode") String currencyCode);
}
