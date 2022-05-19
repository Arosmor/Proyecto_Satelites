/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.amosrosado.satelites.entities;

import es.amosrosado.satelites.entities.Planeta;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "SATELITE")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Satelite.findAll", query = "SELECT s FROM Satelite s"),
    @javax.persistence.NamedQuery(name = "Satelite.findById", query = "SELECT s FROM Satelite s WHERE s.id = :id"),
    @javax.persistence.NamedQuery(name = "Satelite.findByNombre", query = "SELECT s FROM Satelite s WHERE s.nombre = :nombre"),
    @javax.persistence.NamedQuery(name = "Satelite.findByDescubiertoPor", query = "SELECT s FROM Satelite s WHERE s.descubiertoPor = :descubiertoPor"),
    @javax.persistence.NamedQuery(name = "Satelite.findByDistanciaAlPlaneta", query = "SELECT s FROM Satelite s WHERE s.distanciaAlPlaneta = :distanciaAlPlaneta"),
    @javax.persistence.NamedQuery(name = "Satelite.findByA\u00f1oDescubrimiento", query = "SELECT s FROM Satelite s WHERE s.a\u00f1oDescubrimiento = :a\u00f1oDescubrimiento"),
    @javax.persistence.NamedQuery(name = "Satelite.findByTemperaturaMedia", query = "SELECT s FROM Satelite s WHERE s.temperaturaMedia = :temperaturaMedia"),
    @javax.persistence.NamedQuery(name = "Satelite.findByGrabedad", query = "SELECT s FROM Satelite s WHERE s.grabedad = :grabedad"),
    @javax.persistence.NamedQuery(name = "Satelite.findByMisionesEspaciales", query = "SELECT s FROM Satelite s WHERE s.misionesEspaciales = :misionesEspaciales"),
    @javax.persistence.NamedQuery(name = "Satelite.findByTama\u00f1oPlaneta", query = "SELECT s FROM Satelite s WHERE s.tama\u00f1oPlaneta = :tama\u00f1oPlaneta"),
    @javax.persistence.NamedQuery(name = "Satelite.findByFoto", query = "SELECT s FROM Satelite s WHERE s.foto = :foto")})
public class Satelite implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID")
    private Integer id;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "NOMBRE")
    private String nombre;
    @javax.persistence.Column(name = "DESCUBIERTO_POR")
    private String descubiertoPor;
    @javax.persistence.Column(name = "DISTANCIA_AL_PLANETA")
    private String distanciaAlPlaneta;
    @javax.persistence.Column(name = "A\u00d1O_DESCUBRIMIENTO")
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private Date añoDescubrimiento;
    @javax.persistence.Column(name = "TEMPERATURA_MEDIA")
    private Short temperaturaMedia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Column(name = "GRABEDAD")
    private BigDecimal grabedad;
    @javax.persistence.Column(name = "MISIONES_ESPACIALES")
    private Boolean misionesEspaciales;
    @javax.persistence.Column(name = "TAMA\u00d1O_PLANETA")
    private Character tamañoPlaneta;
    @javax.persistence.Column(name = "FOTO")
    private String foto;
    @javax.persistence.JoinColumn(name = "PLANETA", referencedColumnName = "ID")
    @javax.persistence.ManyToOne
    private Planeta planeta;

    public Satelite() {
    }

    public Satelite(Integer id) {
        this.id = id;
    }

    public Satelite(Integer id, String nombre) {
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

    public String getDescubiertoPor() {
        return descubiertoPor;
    }

    public void setDescubiertoPor(String descubiertoPor) {
        this.descubiertoPor = descubiertoPor;
    }

    public String getDistanciaAlPlaneta() {
        return distanciaAlPlaneta;
    }

    public void setDistanciaAlPlaneta(String distanciaAlPlaneta) {
        this.distanciaAlPlaneta = distanciaAlPlaneta;
    }

    public Date getAñoDescubrimiento() {
        return añoDescubrimiento;
    }

    public void setAñoDescubrimiento(Date añoDescubrimiento) {
        this.añoDescubrimiento = añoDescubrimiento;
    }

    public Short getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(Short temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public BigDecimal getGrabedad() {
        return grabedad;
    }

    public void setGrabedad(BigDecimal grabedad) {
        this.grabedad = grabedad;
    }

    public Boolean getMisionesEspaciales() {
        return misionesEspaciales;
    }

    public void setMisionesEspaciales(Boolean misionesEspaciales) {
        this.misionesEspaciales = misionesEspaciales;
    }

    public Character getTamañoPlaneta() {
        return tamañoPlaneta;
    }

    public void setTamañoPlaneta(Character tamañoPlaneta) {
        this.tamañoPlaneta = tamañoPlaneta;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
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
        if (!(object instanceof Satelite)) {
            return false;
        }
        Satelite other = (Satelite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.amosrosado.satelites.entities.Satelite[ id=" + id + " ]";
    }
    
}
