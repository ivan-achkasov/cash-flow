package com.achkasov.cashflow.statistic.rest

import com.achkasov.cashflow.common.model.Currency
import com.achkasov.cashflow.statistic.service.AccountStatisticService
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@CrossOrigin
@RestController
@RequestMapping("/accounts/statistic")
class AccountStatisticRestController(private val accountStatisticService: AccountStatisticService) {

    @GetMapping("totalByCurrency")
    fun getTotalByCurrency(): Map<Currency, Double> = accountStatisticService.getTotalAmountByCurrency()

    @GetMapping("totalInCurrency")
    fun getTotalInCurrency(@RequestParam("currency") currency: Currency): Double {
        val exchangeRate: Map<String, Double> = mapOf("UAH" to 1.0, "USD" to 26.17, "EUR" to 29.96)
        val resultCurrencyRate = exchangeRate[currency.name]!!
        val totalByCurrency = accountStatisticService.getTotalAmountByCurrency();
        return totalByCurrency.entries.stream()
            .map { entity -> exchangeRate[entity.key.name]!! * entity.value / resultCurrencyRate }
            .collect(Collectors.summingDouble(Double::toDouble))
    }
}