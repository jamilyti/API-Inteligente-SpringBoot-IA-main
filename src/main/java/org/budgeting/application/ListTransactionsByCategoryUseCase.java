package org.budgeting.application;



import org.budgeting.application.output.TransactionOutput;
import org.budgeting.domain.Category;
import org.budgeting.domain.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListTransactionsByCategoryUseCase {
    private final ListTransactionsByCategoryUseCase transactionsRepository;

    public ListTransactionsByCategoryUseCase(ListTransactionsByCategoryUseCase transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public List<TransactionOutput> execute(Category category) {
        return transactionsRepository.execute(category);
    }


}
