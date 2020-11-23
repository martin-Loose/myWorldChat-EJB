/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Chatmessage;
import java.util.Date;
import javax.inject.Inject;
import jpa.ChatmessageFacadeLocal;
import jpa.ChatroomFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class ChatCreatePosting_EJB {
  private int myID;
  private String senderName;
private int chatID;
private final int maxZeichen=200;
private int rest=200;
private String myMessage;

@Inject
private ChatroomFacadeLocal chatRoomFacade;
@Inject
private ChatmessageFacadeLocal chatMESSAGEFacade;

public void test(){
setRest(maxZeichen-myMessage.length());
}
public String writeMessage(String myNAme,int chatRoomID){
if(myMessage.length()>0){
Chatmessage myPosting=new Chatmessage();
myPosting.setChatID(chatRoomID);
myPosting.setSenderName(myNAme);
myPosting.setChatMessage(myMessage);
myPosting.setTargetName("all");
myPosting.setWann(new Date());
chatMESSAGEFacade.create(myPosting);
}
    return null;
}
    public int getMyID() {
        return myID;
    }

    public void setMyID(int myID) {
        this.myID = myID;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int par) {
        this.rest = par;
    }

    public String getMyMessage() {
        return myMessage;
    }

    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }



}
