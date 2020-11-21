/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlo0212
 */
@Entity
@Table(catalog = "myworld_chatroom", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@NamedQueries({
       @NamedQuery(name = "Chatroom.findAll", query = "SELECT c FROM Chatroom c")
        , @NamedQuery(name = "Chatroom.findRoomByNameContains", query = "SELECT c FROM Chatroom c WHERE c.name LIKE CONCAT('%', :searchString,'%')")
        , @NamedQuery(name = "Chatroom.findRoomThemeContains", query = "SELECT c FROM Chatroom c WHERE c.theme LIKE CONCAT('%', :searchString,'%')")
    , @NamedQuery(name = "Chatroom.findById", query = "SELECT c FROM Chatroom c WHERE c.id = :id")
    , @NamedQuery(name = "Chatroom.findByName", query = "SELECT c FROM Chatroom c WHERE c.name = :name")
        , @NamedQuery(name = "Chatroom.findByTheme", query = "SELECT c FROM Chatroom c WHERE c.theme = :theme")
    , @NamedQuery(name = "Chatroom.findByCreatorID", query = "SELECT c FROM Chatroom c WHERE c.creatorID = :creatorID")
    , @NamedQuery(name = "Chatroom.findByIsPrivate", query = "SELECT c FROM Chatroom c WHERE c.isPrivate = :isPrivate")
    , @NamedQuery(name = "Chatroom.findByIsPublic", query = "SELECT c FROM Chatroom c WHERE c.isPublic = :isPublic")
    , @NamedQuery(name = "Chatroom.findByPassword", query = "SELECT c FROM Chatroom c WHERE c.password = :password")
    , @NamedQuery(name = "Chatroom.findByIsClosed", query = "SELECT c FROM Chatroom c WHERE c.isClosed = :isClosed")})
/**
  , @NamedQuery(name = "Users.findByStartString", query = "SELECT u FROM Users u WHERE  u.username LIKE CONCAT('%', :searchString,'%')")// LIKE CONCAT('%',:searchKeyword,'%')"
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")//searchKeyword+"%" means return values which starts with searchKeyword.
//"%"+searchKeyword+"%" means return values which contains searchKeyword.**/
public class Chatroom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int creatorID;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean isPrivate;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean isPublic;
    @Size(max = 255)
    @Column(length = 255)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean isClosed;
    @Size(max = 150)
    @Column(length = 150)
    private String theme;

    public Chatroom() {
    }

    public Chatroom(Integer id) {
        this.id = id;
    }

    public Chatroom(Integer id, String name, int creatorID, boolean isPrivate, boolean isPublic, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.creatorID = creatorID;
        this.isPrivate = isPrivate;
        this.isPublic = isPublic;
        this.isClosed = isClosed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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
        if (!(object instanceof Chatroom)) {
            return false;
        }
        Chatroom other = (Chatroom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Chatroom[ id=" + id + " ]";
    }
    
}
