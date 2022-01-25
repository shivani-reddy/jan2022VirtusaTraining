//package com.virtusatraining.assignment2.services;
//
//import com.virtusatraining.assignment2.models.Currency;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//
//@DataJpaTest
//public class CurrencyServiceTest {
//    @Autowired
//    private CurrencyService currencyService;
//    Currency americanCurrency = new Currency("Lire","Greece","₤");
//
//    @BeforeEach
//    void setUp(){
//        currencyService.addCurrency(americanCurrency);
//    }
//
//    @AfterEach
//    void cleanUp(){
//        currencyService.deleteAllCurrency();
//    }
//
//    @Test
//    void findAllCurrencies(){
//        List<Currency> result = currencyService.getAllCurrencies();
//        Assertions.assertNotNull(result);
//    }
//
//}
