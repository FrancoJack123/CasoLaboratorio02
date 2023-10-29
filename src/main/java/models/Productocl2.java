package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "productocl2")
public class Productocl2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPRODUCTOCL2", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "NOMBRECL2")
    private String nombrecl2;

    @Column(name = "PRECIOVENTACL2")
    private Double precioventacl2;

    @Column(name = "PRECIOCOMPCL2")
    private Double preciocompcl2;

    @Size(max = 255)
    @Column(name = "ESTADOCL2")
    private String estadocl2;

    @Size(max = 255)
    @Column(name = "DESCRIPCL2")
    private String descripcl2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrecl2() {
        return nombrecl2;
    }

    public void setNombrecl2(String nombrecl2) {
        this.nombrecl2 = nombrecl2;
    }

    public Double getPrecioventacl2() {
        return precioventacl2;
    }

    public void setPrecioventacl2(Double precioventacl2) {
        this.precioventacl2 = precioventacl2;
    }

    public Double getPreciocompcl2() {
        return preciocompcl2;
    }

    public void setPreciocompcl2(Double preciocompcl2) {
        this.preciocompcl2 = preciocompcl2;
    }

    public String getEstadocl2() {
        return estadocl2;
    }

    public void setEstadocl2(String estadocl2) {
        this.estadocl2 = estadocl2;
    }

    public String getDescripcl2() {
        return descripcl2;
    }

    public void setDescripcl2(String descripcl2) {
        this.descripcl2 = descripcl2;
    }
}