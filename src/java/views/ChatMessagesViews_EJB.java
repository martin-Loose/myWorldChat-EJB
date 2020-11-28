/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Chatmessage;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
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
   private String chatName;
   @Inject
   private ChatroomFacadeLocal chatRoomFacade;
   @Inject
private ChatmessageFacadeLocal chatMessageFacade;
private String init;

    public List<Chatmessage> getThisRoom() {
        thisRoom=new ArrayList<>();
        try{
            thisRoom=chatMessageFacade.findRoomMessages(chatID);
        return thisRoom;
        }catch(NullPointerException np){
        
        }
        return thisRoom;
    }

    public void setThisRoom(List<Chatmessage> thisRoom) {
        this.thisRoom = thisRoom;
    }


    public void senden(){
    setInit(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
    setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
        printInit();
    }
public String printInit(){
    System.err.println("init: "+getInit());
    return "newjsf1";
}
    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }
    
   public String join(){
       setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
        setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));

       return "blankChatRoom";
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

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
   
}
