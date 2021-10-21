package com.achkasov.cashflow.account.data

import com.achkasov.cashflow.account.model.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface AccountRepository: CrudRepository<Account, Long>