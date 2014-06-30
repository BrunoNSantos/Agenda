/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apresentacao;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "contato", catalog = "agenda", schema = "")
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c"),
    @NamedQuery(name = "Contato.findById", query = "SELECT c FROM Contato c WHERE c.id = :id"),
    @NamedQuery(name = "Contato.findByNome", query = "SELECT c FROM Contato c WHERE c.nome = :nome"),
    @NamedQuery(name = "Contato.findByTel1", query = "SELECT c FROM Contato c WHERE c.tel1 = :tel1"),
    @NamedQuery(name = "Contato.findByTel2", query = "SELECT c FROM Contato c WHERE c.tel2 = :tel2"),
    @NamedQuery(name = "Contato.findByTel3", query = "SELECT c FROM Contato c WHERE c.tel3 = :tel3"),
    @NamedQuery(name = "Contato.findByEmail", query = "SELECT c FROM Contato c WHERE c.email = :email"),
    @NamedQuery(name = "Contato.findByObservacoes", query = "SELECT c FROM Contato c WHERE c.observacoes = :observacoes")})
public class Contato implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "tel_1")
    private int tel1;
    @Column(name = "tel_2")
    private Integer tel2;
    @Column(name = "tel_3")
    private Integer tel3;
    @Column(name = "email")
    private String email;
    @Column(name = "observacoes")
    private String observacoes;

    public Contato() {
    }

    public Contato(Integer id) {
        this.id = id;
    }

    public Contato(Integer id, String nome, int tel1) {
        this.id = id;
        this.nome = nome;
        this.tel1 = tel1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public int getTel1() {
        return tel1;
    }

    public void setTel1(int tel1) {
        int oldTel1 = this.tel1;
        this.tel1 = tel1;
        changeSupport.firePropertyChange("tel1", oldTel1, tel1);
    }

    public Integer getTel2() {
        return tel2;
    }

    public void setTel2(Integer tel2) {
        Integer oldTel2 = this.tel2;
        this.tel2 = tel2;
        changeSupport.firePropertyChange("tel2", oldTel2, tel2);
    }

    public Integer getTel3() {
        return tel3;
    }

    public void setTel3(Integer tel3) {
        Integer oldTel3 = this.tel3;
        this.tel3 = tel3;
        changeSupport.firePropertyChange("tel3", oldTel3, tel3);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        String oldObservacoes = this.observacoes;
        this.observacoes = observacoes;
        changeSupport.firePropertyChange("observacoes", oldObservacoes, observacoes);
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
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apresentacao.Contato[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
