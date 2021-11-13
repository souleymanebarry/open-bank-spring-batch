package com.barry.jobconfig;

import com.barry.entities.BankTransaction;
import lombok.Getter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

//@Component
public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction, BankTransaction> {


    @Getter private double totalDebit;
    @Getter private double totalCredit;

    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        if(bankTransaction.getTransactionType().equals("D"))
           totalDebit = totalDebit+ bankTransaction.getAmount();
        if(bankTransaction.getTransactionType().equals("C"))
            totalCredit = totalCredit+ bankTransaction.getAmount();
        return bankTransaction;
    }
}
