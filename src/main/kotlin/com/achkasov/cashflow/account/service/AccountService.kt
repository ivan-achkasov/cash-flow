package com.achkasov.cashflow.account.service

import com.achkasov.cashflow.data.account.dto.AccountRepository
import com.achkasov.cashflow.account.model.Account
import org.springframework.stereotype.Service

@Service
class AccountService (private val accountRepository: AccountRepository) {
    fun findAll() : List<Account> = accountRepository.findAll();
}