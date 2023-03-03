package it.numble.numbletimedeal.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Table(name = "purchase")
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE purchase SET deleted = true WHERE id = ?")
public class PurchaseEntity extends BaseEntity {

    @NotNull
    @ColumnDefault("1")
    @Column(name = "quantity")
    private Long quantity = 1L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity buyer;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    protected PurchaseEntity() {
    }

    @Builder
    public PurchaseEntity(Long quantity, UserEntity buyer, ProductEntity product) {
        this.quantity = quantity;
        this.buyer = buyer;
        this.product = product;
    }
}

