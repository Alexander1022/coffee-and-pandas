package com.fmi.entertizer.model.entity;

import com.fmi.entertizer.model.entity.enums.Status;
import jakarta.persistence.*;


@Entity
@Table(name = "friends")
public class Friend extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "first_user_id", referencedColumnName = "id")
    User firstUser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "second_user_id", referencedColumnName = "id")
    User secondUser;

    @Enumerated(EnumType.ORDINAL)
    Status status;

    public Friend() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }
}
