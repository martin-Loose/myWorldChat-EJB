/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlo0212
 */
@Entity
@Table(catalog = "myworld_chatroom", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chatmessage.findAll", query = "SELECT c FROM Chatmessage c")
         , @NamedQuery(name = "Chatmessage.findByChatID", query = "SELECT c FROM Chatmessage c WHERE c.chatID = :chatID ORDER BY c.wann DESC")
        , @NamedQuery(name = "Chatmessage.sortBySenderAndTarget", query = "SELECT c FROM Chatmessage c WHERE c.id = :id AND c.targetName =:targetName")
    , @NamedQuery(name = "Chatmessage.findById", query = "SELECT c FROM Chatmessage c WHERE c.id = :id")
    , @NamedQuery(name = "Chatmessage.findBySenderName", query = "SELECT c FROM Chatmessage c WHERE c.senderName = :senderName")
    , @NamedQuery(name = "Chatmessage.findByChatMessage", query = "SELECT c FROM Chatmessage c WHERE c.chatMessage = :chatMessage")
    , @NamedQuery(name = "Chatmessage.findByWann", query = "SELECT c FROM Chatmessage c WHERE c.wann = :wann")
    , @NamedQuery(name = "Chatmessage.findByTargetName", query = "SELECT c FROM Chatmessage c WHERE c.targetName = :targetName")})

public class Chatmessage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String senderName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String chatMessage;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int chatID;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date wann;
    @Size(max = 40)
    @Column(length = 40)
    private String targetName;

    public Chatmessage() {
    }

    public Chatmessage(Integer id) {
        this.id = id;
    }

    public Chatmessage(Integer id, String senderName, String chatMessage, int chatID, Date wann) {
        this.id = id;
        this.senderName = senderName;
        this.chatMessage = chatMessage;
        this.chatID = chatID;
        this.wann = wann;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public Date getWann() {
        return wann;
    }

    public void setWann(Date wann) {
        this.wann = wann;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
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
        if (!(object instanceof Chatmessage)) {
            return false;
        }
        Chatmessage other = (Chatmessage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Chatmessage[ id=" + id + " ]";
    }
    
}
