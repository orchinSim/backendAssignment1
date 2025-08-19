package com.smartcity.user.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone")
})
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String phone;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, name = "password_hash")
    private String passwordHash;

    private String locale = "en";
    private String tz = "Asia/Kolkata";

    // getters/setters
    // (Generate with STS or write manually)
    public Long getId() { return id; }
    public void setId(Long id){ this.id=id; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email=email; }
    public String getPhone(){ return phone; }
    public void setPhone(String phone){ this.phone=phone; }
    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }
    public String getPasswordHash(){ return passwordHash; }
    public void setPasswordHash(String passwordHash){ this.passwordHash=passwordHash; }
    public String getLocale(){ return locale; }
    public void setLocale(String locale){ this.locale=locale; }
    public String getTz(){ return tz; }
    public void setTz(String tz){ this.tz=tz; }
}
