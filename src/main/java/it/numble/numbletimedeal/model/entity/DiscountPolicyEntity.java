package it.numble.numbletimedeal.model.entity;

import it.numble.numbletimedeal.model.enumerate.DiscountType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Table(name = "discount_policy")
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE discount_policy SET deleted = true WHERE id = ?")
public class DiscountPolicyEntity extends BaseEntity {

    @NotNull
    @Column(name = "discount_type")
    private DiscountType discountType;

    @NotNull
    @Column(name = "discount_amount")
    private Long discountAmount;

    protected DiscountPolicyEntity() {
    }

    @Builder
    public DiscountPolicyEntity(DiscountType discountType, Long discountAmount) {
        this.discountType = discountType;
        this.discountAmount = discountAmount;
    }
}
