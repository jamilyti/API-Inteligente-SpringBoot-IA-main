package org.budgeting.application;

import org.budgeting.application.Input.PersistTransactionInput;
import org.budgeting.application.output.TransactionOutput;
import org.budgeting.domain.Category;
import org.budgeting.domain.Transaction;
import org.budgeting.domain.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class PersistTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public PersistTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionOutput execute(PersistTransactionInput input) {
        var  transaction = transactionRepository.save(
                new Transaction(input.description(), input.amount(), input.category()));
        return TransactionOutput.from(transaction) ;

    }

}
