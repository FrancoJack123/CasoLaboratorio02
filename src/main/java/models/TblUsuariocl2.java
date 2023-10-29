package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_usuariocl2")
public class TblUsuariocl2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUSUARIOCL2", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "USUARIOCL2")
    private String usuariocl2;

    @Size(max = 255)
    @Column(name = "PASSWORDCL2")
    private String passwordcl2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuariocl2() {
        return usuariocl2;
    }

    public void setUsuariocl2(String usuariocl2) {
        this.usuariocl2 = usuariocl2;
    }

    public String getPasswordcl2() {
        return passwordcl2;
    }

    public void setPasswordcl2(String passwordcl2) {
        this.passwordcl2 = passwordcl2;
    }
}