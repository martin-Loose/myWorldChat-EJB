/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Chatmessage;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marlo0212
 */
@Stateless
public class ChatmessageFacade extends AbstractFacade<Chatmessage> implements ChatmessageFacadeLocal {

    @PersistenceContext(unitName = "myWorldChatRoom-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChatmessageFacade() {
        super(Chatmessage.class);
    }

    @Override
    public List<Chatmessage> findRoomMessages(int chatRoomID) {
       List<Chatmessage> myList=new ArrayList<>();
     try{
     myList=em.createNamedQuery("Chatmessage.findByChatID",Chatmessage.class)
             .setParameter("chatID", chatRoomID).getResultList();
     }catch(Exception e){
     }
       return myList;  
    }
    
}
