package it.numble.numbletimedeal.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Table(name = "product")
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id = ?")
public class ProductEntity extends BaseEntity {

    @NotNull
    @Column(name = "name", length = 100)
    private String name;

    @NotNull
    @Column(name = "cutoff_time")
    private LocalDateTime cutoffTime;

    @NotNull
    @Column(name = "list_price")
    private Long listPrice;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discount_policy_id")
    private DiscountPolicyEntity discountPolicy;

    // TODO: Redis에 저장한다. stock 만 조회하는 API도 만들자.
    // <Key, Value> : <ProductId, StockAmount>
    private Long stockAmount;

    protected ProductEntity() {
    }

    @Builder
    public ProductEntity(String name, LocalDateTime cutoffTime, Long listPrice, DiscountPolicyEntity discountPolicy, Long stockAmount) {
        this.name = name;
        this.cutoffTime = cutoffTime;
        this.listPrice = listPrice;
        this.discountPolicy = discountPolicy;
        this.stockAmount = stockAmount;
    }
}
