/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Chatroom;
import javax.inject.Inject;
import jpa.ChatroomFacadeLocal;


/**
 *
 * @author marlo0212
 */
public class CreateChatroomController_EJB {
    private String chatRoomName;
    private int myID;
    private Boolean isPublic;
    private Boolean isClosed;
    private Boolean isPrivate;
    private String password;
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
    public void createChatroom(){
    try{
        if(chatroomFacade.findRoomByName(chatRoomName).isEmpty()){
          Chatroom myRoom=new Chatroom();
          myRoom.setCreatorID(getMyID());
          myRoom.setIsClosed(false);
          myRoom.setTheme(theme);
          myRoom.setIsPrivate(false);
          myRoom.setIsPublic(true);
          myRoom.setName(chatRoomName);
          if(password.length()>0){
          myRoom.setPassword(getPassword());
          }
          chatroomFacade.create(myRoom);
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

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

       
}
