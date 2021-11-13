package com.achkasov.cashflow.account.service

import com.achkasov.cashflow.account.data.AccountRepository
import com.achkasov.cashflow.account.model.Account
import org.springframework.stereotype.Service

@Service
class AccountService (private val accountRepository: AccountRepository) {
    fun findAll() : List<Account> = accountRepository.findAll();
}