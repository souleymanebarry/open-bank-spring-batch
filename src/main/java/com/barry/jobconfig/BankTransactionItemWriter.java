package com.barry.jobconfig;

import com.barry.dao.BankTransactionRepository;
import com.barry.entities.BankTransaction;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BankTransactionItemWriter implements ItemWriter<BankTransaction> {

    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    @Override
    public void write(List<? extends BankTransaction> list) {
        bankTransactionRepository.saveAll(list);
    }
}
