package org.budgeting.infrastructure.persistence.http.request;

import org.budgeting.application.Input.PersistTransactionInput;
import org.budgeting.domain.Category;

public record TransactionRequest(String description, Category category, long amount) {
    public PersistTransactionInput toInput() {
        return new PersistTransactionInput(description,amount, category);
    }
}
