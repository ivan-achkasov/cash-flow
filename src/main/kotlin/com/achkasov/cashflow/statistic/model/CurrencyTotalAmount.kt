package com.achkasov.cashflow.statistic.model

import com.achkasov.cashflow.common.model.Currency

data class CurrencyTotalAmount(
    val currency: Currency,
    val totalAmount: Double
)
