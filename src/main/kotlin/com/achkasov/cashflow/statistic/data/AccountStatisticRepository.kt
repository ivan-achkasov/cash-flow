package com.achkasov.cashflow.statistic.data

import com.achkasov.cashflow.account.model.Account
import com.achkasov.cashflow.statistic.model.CurrencyTotalAmount
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.data.repository.Repository as SpringRepository;

@Repository
interface AccountStatisticRepository: SpringRepository<Account, Long> {

    @Query("SELECT new com.achkasov.cashflow.statistic.model.CurrencyTotalAmount(currency, SUM(amount))" +
            "FROM Account " +
            "GROUP BY currency")
    fun getTotalAmountByCurrency(): List<CurrencyTotalAmount>
}