/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Chatmessage;
import entities.Chatroom;
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
public class PrivateChatMessagesViews_EJB {
 private List<Chatmessage> thisRoom;
    private String password;
    private List<Chatmessage> thisGlobalRoom;
    private int chatID;
    private int chatTest = 0;
    private String chatName;
    private Chatroom selectedRoom;
    private boolean passwordMatch;
    @Inject
    private ChatroomFacadeLocal chatRoomFacade;
    @Inject
    private ChatmessageFacadeLocal chatMessageFacade;
    private String init;
@Inject
private ChatroomFacadeLocal chatroomFacade;
    public List<Chatmessage> getThisRoom() {
        thisRoom = new ArrayList<>();
        try {
            thisRoom = chatMessageFacade.findRoomMessages(chatID);
            return thisRoom;
        } catch (NullPointerException np) {

        }
        return thisRoom;
    }

    public void setThisRoom(List<Chatmessage> thisRoom) {
        this.thisRoom = thisRoom;
    }

    public void initView(){
    setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
        setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
        setSelectedRoom(chatroomFacade.find(chatID));
    }

   
 public String joinPrivate() {
   
     return "blankChatRoom";
    }
    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

   

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
    public Chatroom getSelectedRoom() {

        return chatRoomFacade.find(chatID);
    }

    public void setSelectedRoom(Chatroom selectedRoom) {
        this.selectedRoom = chatRoomFacade.find(chatID);
    }

    public boolean isPasswordMatch() {
        return passwordMatch;
    }

    public void setPasswordMatch(boolean passwordMatch) {
        this.passwordMatch = passwordMatch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 

}

