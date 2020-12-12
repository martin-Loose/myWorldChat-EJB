/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Chatroom;
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
public class ChatroomFacade extends AbstractFacade<Chatroom> implements ChatroomFacadeLocal {

    @PersistenceContext(unitName = "myWorldChatRoom-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChatroomFacade() {
        super(Chatroom.class);
    }
/**
 * not needed - b4 room create check if name is free ( findRoomByName)
 **/
    @Override
    public Chatroom existRoom(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chatroom> findRoomByName(String name) {
List<Chatroom>myLists=new ArrayList<>();
        try{
        myLists=em.createNamedQuery("Chatroom.findByName",Chatroom.class).setParameter("name", name).getResultList();
        return myLists;
        }catch(Exception e){
            return myLists;
    }
    }

    @Override
    public List<Chatroom> findRoomByStartString(String searchString) {
     List<Chatroom>myLists=new ArrayList<>();
        try{
        myLists=em.createNamedQuery("Chatroom.findRoomByNameContains",Chatroom.class).setParameter("name", searchString).getResultList();
        return myLists;
        }catch(Exception e){
            return myLists;
    }
    }

    @Override
    public List<Chatroom> findRoomByNameContains(String searchString) {
    List<Chatroom>myLists=new ArrayList<>();
        try{
        myLists=em.createNamedQuery("Chatroom.findRoomByNameContains",Chatroom.class)
                .setParameter("searchString", searchString).getResultList();
        return myLists;
        }catch(Exception e){
            return myLists;
    }
    }

    @Override
    public List<Chatroom> findMyCreatedRooms(int searchID) {
    List<Chatroom>myLists=new ArrayList<>();
        try{
        myLists=em.createNamedQuery("Chatroom.findByCreatorID",Chatroom.class).setParameter("creatorID", searchID).getResultList();
        return myLists;
        }catch(Exception e){
            return myLists;
    }
    }
/**
 * not implemented - cause plan is - window.unload =>remove user from chat
     * @param searchID
     * @return 
 **/
    @Override
    public List<Chatroom> findRoomsWhereImIn(int searchID) {
    List<Chatroom>myLists=new ArrayList<>();
        try{
        myLists=em.createNamedQuery("Chatroom.findByName",Chatroom.class).setParameter("name", searchID).getResultList();
        return myLists;
        }catch(Exception e){
            return myLists;
    }
    }

    @Override
    public List<Chatroom> findRoomByThemeContains(String searchString) {
       List<Chatroom>myLists=new ArrayList<>();
        try{
        myLists=em.createNamedQuery("Chatroom.findRoomThemeContains",Chatroom.class).setParameter("theme", searchString).getResultList();
        return myLists;
        }catch(Exception e){
            return myLists;
    }
    }

    @Override
    public List<Chatroom> findRoomByTheme(String searchString) {
    List<Chatroom>myLists=new ArrayList<>();
        try{
        myLists=em.createNamedQuery("Chatroom.findByTheme",Chatroom.class).setParameter("theme", searchString).getResultList();
        return myLists;
        }catch(Exception e){
            return myLists;
    }
    }

    @Override
    public List<Chatroom> findPublicRooms(boolean isPublic) {
     List<Chatroom>myLists=new ArrayList<>();
        try{
        myLists=em.createNamedQuery("Chatroom.findByIsPublic",Chatroom.class).setParameter("isPublic", true).getResultList();
        return myLists;
        }catch(Exception e){
            return myLists;
    }
    }
    
}
