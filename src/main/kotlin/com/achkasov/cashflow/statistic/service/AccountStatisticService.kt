package com.achkasov.cashflow.statistic.service

import com.achkasov.cashflow.common.model.Currency
import com.achkasov.cashflow.statistic.data.AccountStatisticRepository
import com.achkasov.cashflow.statistic.model.CurrencyTotalAmount
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AccountStatisticService(private val accountStatisticRepository: AccountStatisticRepository) {

    fun getTotalAmountByCurrency(): Map<Currency, Double> = accountStatisticRepository
        .getTotalAmountByCurrency()
        .stream()
        .collect(Collectors.toMap(CurrencyTotalAmount::currency, CurrencyTotalAmount::totalAmount))

}