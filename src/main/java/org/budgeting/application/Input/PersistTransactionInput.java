package org.budgeting.application.Input;

import org.budgeting.domain.Category;

public record PersistTransactionInput (String description, long amount, Category category){
}
