package com.bigodebombado.backend.Model.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user_details")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    private String email;
    private String password;
    private UserRole role;

    private String exp1;
    private String empresa1;

    private String period1;

    private String exp2;

    private String empresa2;

    private String period2;

    private String exp3;

    private String empresa3;

    private String period3;

    private String acaTit1;

    private String acaCon1;

    private String acaTit2;

    private String acaCon2;

    private String lan1;

    private String lanLv1;

    private String lan2;

    private String lanLv2;

    private String hardSkl1;

    private String hardSkl2;

    private String hardSkl3;

    private String softSkl1;;

    private String softSkl2;;

    private String softSkl3;

    public User(String firstName, String lastName, String email, String password, String exp1, String empresa1, String period1, String exp2, String empresa2, String period2, String exp3, String empresa3, String period3, String acaTit1, String acaCon1, String acaTit2, String acaCon2, String  lan1, String lanLv1, String lan2, String lanLv2, String hardSkl1, String hardSkl2, String hardSkl3, String softSkl1, String softSkl2, String softSkl3) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = UserRole.USER;
        this.exp1 = exp1;
        this.empresa1 = empresa1;
        this.period1 = period1;
        this.exp2 = exp2;
        this.empresa2 = empresa2;
        this.period2 = period2;
        this.exp3 = exp3;
        this.empresa3 = empresa3;
        this.period3 = period3;
        this.acaTit1 = acaTit1;
        this.acaCon1 = acaCon1;
        this.acaTit2 = acaTit2;
        this.acaCon2 = acaCon2;
        this.lan1 = lan1;
        this.lanLv1 = lanLv1;
        this.lan2 = lan2;
        this.lanLv2 = lanLv2;
        this.hardSkl1 = hardSkl1;
        this.hardSkl2 = hardSkl2;
        this.hardSkl3 = hardSkl3;
        this.softSkl1 = softSkl1;;
        this.softSkl2 = softSkl2;;
        this.softSkl3 = softSkl3;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getExp1() {
        return exp1;
    }

    public void setExp1(String exp1) {
        this.exp1 = exp1;
    }

    public String getEmpresa1() {
        return empresa1;
    }

    public void setEmpresa1(String empresa1) {
        this.empresa1 = empresa1;
    }

    public String getPeriod1() {
        return period1;
    }

    public void setPeriod1(String period1) {
        this.period1 = period1;
    }

    public String getExp2() {
        return exp2;
    }

    public void setExp2(String exp2) {
        this.exp2 = exp2;
    }

    public String getEmpresa2() {
        return empresa2;
    }

    public void setEmpresa2(String empresa2) {
        this.empresa2 = empresa2;
    }

    public String getPeriod2() {
        return period2;
    }

    public void setPeriod2(String period2) {
        this.period2 = period2;
    }

    public String getExp3() {
        return exp3;
    }

    public void setExp3(String exp3) {
        this.exp3 = exp3;
    }

    public String getEmpresa3() {
        return empresa3;
    }

    public void setEmpresa3(String empresa3) {
        this.empresa3 = empresa3;
    }

    public String getPeriod3() {
        return period3;
    }

    public void setPeriod3(String period3) {
        this.period3 = period3;
    }

    public String getAcaTit1() {
        return acaTit1;
    }

    public void setAcaTit1(String acaTit1) {
        this.acaTit1 = acaTit1;
    }

    public String getAcaCon1() {
        return acaCon1;
    }

    public void setAcaCon1(String acaCon1) {
        this.acaCon1 = acaCon1;
    }

    public String getAcaTit2() {
        return acaTit2;
    }

    public void setAcaTit2(String acaTit2) {
        this.acaTit2 = acaTit2;
    }

    public String getAcaCon2() {
        return acaCon2;
    }

    public void setAcaCon2(String acaCon2) {
        this.acaCon2 = acaCon2;
    }

    public String getLan1() {
        return lan1;
    }

    public void setLan1(String lan1) {
        this.lan1 = lan1;
    }

    public String getLanLv1() {
        return lanLv1;
    }

    public void setLanLv1(String lanLv1) {
        this.lanLv1 = lanLv1;
    }

    public String getLan2() {
        return lan2;
    }

    public void setLan2(String lan2) {
        this.lan2 = lan2;
    }

    public String getLanLv2() {
        return lanLv2;
    }

    public void setLanLv2(String lanLv2) {
        this.lanLv2 = lanLv2;
    }

    public String getHardSkl1() {
        return hardSkl1;
    }

    public void setHardSkl1(String hardSkl1) {
        this.hardSkl1 = hardSkl1;
    }

    public String getHardSkl2() {
        return hardSkl2;
    }

    public void setHardSkl2(String hardSkl2) {
        this.hardSkl2 = hardSkl2;
    }

    public String getHardSkl3() {
        return hardSkl3;
    }

    public void setHardSkl3(String hardSkl3) {
        this.hardSkl3 = hardSkl3;
    }

    public String getSoftSkl1() {
        return softSkl1;
    }

    public void setSoftSkl1(String softSkl1) {
        this.softSkl1 = softSkl1;
    }

    public String getSoftSkl2() {
        return softSkl2;
    }

    public void setSoftSkl2(String softSkl2) {
        this.softSkl2 = softSkl2;
    }

    public String getSoftSkl3() {
        return softSkl3;
    }

    public void setSoftSkl3(String softSkl3) {
        this.softSkl3 = softSkl3;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String   toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", exp1='" + exp1 + '\'' +
                ", empresa1='" + empresa1 + '\'' +
                ", period1='" + period1 + '\'' +
                ", acaTit1='" + acaTit1 + '\'' +
                ", acaCon1='" + acaCon1 + '\'' +
                ", acaTit2='" + acaTit2 + '\'' +
                ", acaCon2='" + acaCon2 + '\'' +
                ", lan1='" + lan1 + '\'' +
                ", lanLv1='" + lanLv1 + '\'' +
                ", lan2='" + lan2 + '\'' +
                ", lanLv2='" + lanLv2 + '\'' +
                ", hardSkl1='" + hardSkl1 + '\'' +
                ", hardSkl2='" + hardSkl2 + '\'' +
                ", hardSkl3='" + hardSkl3 + '\'' +
                ", softSkl1='" + softSkl1 + '\'' +
                ", softSkl2='" + softSkl2 + '\'' +
                ", softSkl3='" + softSkl3 + '\'' +

                '}';
    }
}
