/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Chatroom;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import jpa.ChatroomFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class ChatroomViews_EJB {
    private List<Chatroom> myList;
    private Chatroom selectedChatroom;
    
    @Inject
    private ChatroomFacadeLocal chatRoomFacade;

    public List<Chatroom> getMyList() {
         myList=new ArrayList<>();
        try{
       
        myList=chatRoomFacade.findAll();
        }catch(Exception e){
        
        }
        return myList;
    }

    public void setMyList(List<Chatroom> myList) {
        this.myList = myList;
    }

    public Chatroom getSelectedChatroom() {
        return selectedChatroom;
    }

    public void setSelectedChatroom(Chatroom selectedChatroom) {
        this.selectedChatroom = selectedChatroom;
    }
    
    
}
