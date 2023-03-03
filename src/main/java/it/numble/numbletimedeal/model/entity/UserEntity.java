package it.numble.numbletimedeal.model.entity;

import it.numble.numbletimedeal.model.enumerate.UserRole;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Table(
    name = "user",
    indexes = @Index(name = "ux_email", columnList = "email", unique = true)
)
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id = ?")
public class UserEntity extends BaseEntity {

    @NotNull
    @Column(name = "email", length = 100, unique = true)
    private String email;

    @NotNull
    @Column(name = "password", length = 300)
    private String password;

    @NotNull
    @Column(name = "role", length = 10)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    protected UserEntity() {
    }

    @Builder
    public UserEntity(String email, String password, UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
