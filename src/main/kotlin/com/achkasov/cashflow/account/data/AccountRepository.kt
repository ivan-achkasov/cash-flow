package com.achkasov.cashflow.account.data

import com.achkasov.cashflow.account.model.Account
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: org.springframework.data.repository.Repository<Account, Long> {
    fun findAll(): List<Account>
}