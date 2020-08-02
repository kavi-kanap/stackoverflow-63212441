package com.dateissue;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class);
		TransactionRepository transactionRepository = context.getBean(TransactionRepository.class);
		Transaction transaction
				= transactionRepository.save(new Transaction(BigDecimal.ONE, 1));

		Date fromDate = new Date();
		Date toDate = new Date();
		List<Transaction> transactionList =
				transactionRepository.findByAccountIdWithCreationDateBetween(fromDate, toDate);
		System.out.println("--------------------------------------------------------");
		System.out.println("Transaction Created at : " + transaction.getCreatedAt());
		System.out.println("Number of Transactions retrieved : " + transactionList.size());
	}



}