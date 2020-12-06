/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Chatroom;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import jpa.ChatroomFacadeLocal;


/**
 *
 * @author marlo0212
 */
public class CreateChatroomController_EJB {
    private String chatRoomName;
    private int myID;
     private String theme;
    private int zeichen;
    private final int maxZeichen=150;
    @Inject
    private ChatroomFacadeLocal chatroomFacade;
    
    //*******************
    public void test(){
    setZeichen(maxZeichen-theme.length());
}
    public int getZeichen() {
        return zeichen;
    }

    public void setZeichen(int zeichen) {
        this.zeichen = zeichen;
    }
    public void createChatroom(int id){
    try{
        if(chatroomFacade.findRoomByName(chatRoomName).isEmpty()){
          Chatroom myRoom=new Chatroom();
          myRoom.setCreatorID(id);
          myRoom.setIsClosed(false);
          myRoom.setTheme(theme);
          myRoom.setName(chatRoomName);
          myRoom.setIsPublic(true);
          myRoom.setIsPrivate(false);
          chatroomFacade.create(myRoom);
               FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Chatroom created", "Chatroom created"));    
          
        }
    
    
    }catch(Exception e){
    }
    }
    //*******************

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }

    public int getMyID() {
        return myID;
    }

    public void setMyID(int creatorID) {
        this.myID = creatorID;
    }

   
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

       
}
