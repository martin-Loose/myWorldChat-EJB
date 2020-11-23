/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Chatmessage;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import jpa.ChatmessageFacadeLocal;
import jpa.ChatroomFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class ChatMessagesViews_EJB {
   private List<Chatmessage>thisRoom;
   private List<Chatmessage>thisGlobalRoom;
   private int chatID;
   private int chatTest=0;
   @Inject
   private ChatroomFacadeLocal chatRoomFacade;
   @Inject
private ChatmessageFacadeLocal chatMessageFacade;

   
    public List<Chatmessage> getThisRoom() {
        thisRoom=new ArrayList<>();
        try{
        thisRoom=chatMessageFacade.findRoomMessages(chatID);
        
        }catch(Exception e){
            
    }
        return thisRoom;
    }

    public void setThisRoom(List<Chatmessage> thisRoom) {
        this.thisRoom = thisRoom;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public int getChatTest() {
        return chatTest;
    }

    public void setChatTest(int chatTest) {
        this.chatTest = chatTest;
    }

    public List<Chatmessage> getThisGlobalRoom() {
       thisGlobalRoom=new ArrayList<>();
        try{
        thisGlobalRoom=chatMessageFacade.findRoomMessages(1);
        
        }catch(Exception e){
            
    }
        return thisGlobalRoom;
    }

    public void setThisGlobalRoom(List<Chatmessage> thisGlobalRoom) {
        this.thisGlobalRoom = thisGlobalRoom;
    }
   
   
    }
