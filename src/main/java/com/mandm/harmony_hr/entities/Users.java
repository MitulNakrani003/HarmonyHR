package com.mandm.harmony_hr.entities;

import com.mandm.harmony_hr.models.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;
    @Column(name = "password", nullable = false, length = 200)
    private String password;
    @OneToOne
    @JoinColumn(name = "belongs_to", referencedColumnName = "emp_id")
    private Employee belongsTo;
    @Enumerated(EnumType.STRING)
    private Roles accessRights;

    // Getters and Setters
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Roles getAccessRights() {
        return accessRights;
    }
    public void setAccessRights(Roles accessRights) {
        this.accessRights = accessRights;
    }
    public Employee getBelongsTo() {
        return belongsTo;
    }
    public void setBelongsTo(Employee belongsTo) {
        this.belongsTo = belongsTo;
    }
}
