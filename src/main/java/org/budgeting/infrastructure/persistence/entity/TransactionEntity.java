package org.budgeting.infrastructure.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.budgeting.domain.Category;
import org.budgeting.domain.Transaction;
import org.budgeting.domain.TransactionId;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    @Id
    private UUID id;
    private String description;
    private long amount;
    private Category category;

    public static TransactionEntity from(Transaction transaction) {
       return new TransactionEntity(transaction.getId().uuid(),
               transaction.getDescription(),
               transaction.getAmount(),
               transaction.getCategory());
    }

    public Transaction toDomain() {
        return new Transaction(
              new TransactionId(this.id),
                this.description,
                this.amount,
                this.category

        );
    }
}
