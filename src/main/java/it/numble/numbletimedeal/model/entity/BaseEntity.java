package it.numble.numbletimedeal.model.entity;

import it.numble.numbletimedeal.support.Constants;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = "id", callSuper = false)
@Getter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @Column(name = "deleted", columnDefinition = Constants.DB_DELETED_DEFINITION)
    protected Boolean deleted = false;

    @NotNull
    @CreatedDate
    @Column(name = "created_at", columnDefinition = Constants.DB_CREATED_AT_DEFINITION, updatable = false)
    protected LocalDateTime createdAt;

    @NotNull
    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = Constants.DB_UPDATED_AT_DEFINITION)
    protected LocalDateTime updatedAt;
}
