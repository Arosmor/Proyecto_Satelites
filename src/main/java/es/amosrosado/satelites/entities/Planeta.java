/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.amosrosado.satelites.entities;

import es.amosrosado.satelites.entities.Satelite;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Usuario
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "PLANETA")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Planeta.findAll", query = "SELECT p FROM Planeta p"),
    @javax.persistence.NamedQuery(name = "Planeta.findById", query = "SELECT p FROM Planeta p WHERE p.id = :id"),
    @javax.persistence.NamedQuery(name = "Planeta.findByNombre", query = "SELECT p FROM Planeta p WHERE p.nombre = :nombre"),
    @javax.persistence.NamedQuery(name = "Planeta.findByDistanciaSol", query = "SELECT p FROM Planeta p WHERE p.distanciaSol = :distanciaSol"),
    @javax.persistence.NamedQuery(name = "Planeta.findByGrabedad", query = "SELECT p FROM Planeta p WHERE p.grabedad = :grabedad"),
    @javax.persistence.NamedQuery(name = "Planeta.findByRocoso", query = "SELECT p FROM Planeta p WHERE p.rocoso = :rocoso"),
    @javax.persistence.NamedQuery(name = "Planeta.findByNumSatelites", query = "SELECT p FROM Planeta p WHERE p.numSatelites = :numSatelites"),
    @javax.persistence.NamedQuery(name = "Planeta.findByOrbita", query = "SELECT p FROM Planeta p WHERE p.orbita = :orbita")})
public class Planeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID")
    private Integer id;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "NOMBRE")
    private String nombre;
    @javax.persistence.Column(name = "DISTANCIA_SOL")
    private String distanciaSol;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Column(name = "GRABEDAD")
    private BigDecimal grabedad;
    @javax.persistence.Column(name = "ROCOSO")
    private Boolean rocoso;
    @javax.persistence.Column(name = "NUM_SATELITES")
    private Short numSatelites;
    @javax.persistence.Column(name = "ORBITA")
    private String orbita;
    @javax.persistence.OneToMany(mappedBy = "planeta")
    private Collection<Satelite> sateliteCollection;

    public Planeta() {
    }

    public Planeta(Integer id) {
        this.id = id;
    }

    public Planeta(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistanciaSol() {
        return distanciaSol;
    }

    public void setDistanciaSol(String distanciaSol) {
        this.distanciaSol = distanciaSol;
    }

    public BigDecimal getGrabedad() {
        return grabedad;
    }

    public void setGrabedad(BigDecimal grabedad) {
        this.grabedad = grabedad;
    }

    public Boolean getRocoso() {
        return rocoso;
    }

    public void setRocoso(Boolean rocoso) {
        this.rocoso = rocoso;
    }

    public Short getNumSatelites() {
        return numSatelites;
    }

    public void setNumSatelites(Short numSatelites) {
        this.numSatelites = numSatelites;
    }

    public String getOrbita() {
        return orbita;
    }

    public void setOrbita(String orbita) {
        this.orbita = orbita;
    }

    public Collection<Satelite> getSateliteCollection() {
        return sateliteCollection;
    }

    public void setSateliteCollection(Collection<Satelite> sateliteCollection) {
        this.sateliteCollection = sateliteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planeta)) {
            return false;
        }
        Planeta other = (Planeta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.amosrosado.satelites.entities.Planeta[ id=" + id + " ]";
    }
    
}
