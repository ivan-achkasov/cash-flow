package com.achkasov.cashflow

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class CashFlowApplication

fun main(args: Array<String>) {
	runApplication<CashFlowApplication>(*args)
}
