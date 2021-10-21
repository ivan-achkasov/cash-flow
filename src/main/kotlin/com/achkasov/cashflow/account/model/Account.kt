package com.achkasov.cashflow.account.model

import com.achkasov.cashflow.common.model.Currency
import javax.persistence.*

@Entity
@Table(name = "account")
open class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null;

    @Column(name = "name", unique = true)
    open var name: String? = null;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_code", nullable = false)
    open var currency: Currency? = null;

    @Column(name = "amount", precision = 20, scale = 2, nullable = false)
    open var amount: Double? = null;
}
