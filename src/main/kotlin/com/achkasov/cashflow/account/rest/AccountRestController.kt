package com.achkasov.cashflow.account.rest

import com.achkasov.cashflow.account.model.Account
import com.achkasov.cashflow.account.service.AccountService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/accounts")
class AccountRestController(private val accountService: AccountService) {

    @GetMapping
    fun getAllAccounts(): List<Account> = accountService.findAll()

}