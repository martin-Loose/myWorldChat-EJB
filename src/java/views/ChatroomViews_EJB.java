/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Chatroom;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import jpa.ChatroomFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class ChatroomViews_EJB {

    private List<Chatroom> myNewListOfPublicRooms;
    private List<Chatroom> myNewListOfPrivateRooms;
    private String chatName;
    private int chatID;
    private Chatroom selectedChatroom;
    @Inject
    private ChatroomFacadeLocal chatroomFacade;

    public void senden() {
        setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
        setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
        setSelectedChatroom(chatroomFacade.find(chatID));
    }

    /**
     * public List<Chatroom> getMyNewListOfPrivateRooms() {
     * myNewListOfPublicRooms=new ArrayList<>(); try {
     * myNewListOfPublicRooms=chatroomFacade.findPublicRooms(true); return
     * myNewListOfPublicRooms; } catch(NullPointerException np) {
     *
     * }
     * return myNewListOfPrivateRooms; }
*
     */
    public void setMyNewListOfPrivateRooms(List<Chatroom> myNewListOfPrivateRooms) {
        this.myNewListOfPrivateRooms = myNewListOfPrivateRooms;
    }

    public List<Chatroom> getMyNewListOfPublicRooms() {
        myNewListOfPublicRooms = new ArrayList<>();
        try {
            myNewListOfPublicRooms = chatroomFacade.findPublicRooms(true);
            return myNewListOfPublicRooms;
        } catch (NullPointerException np) {

        }
        return myNewListOfPrivateRooms;
    }

    public void setMyNewListOfPublicRooms(List<Chatroom> myNewListOfPublicRooms) {
        this.myNewListOfPublicRooms = myNewListOfPublicRooms;
    }

    public String getInit() {
        return chatName;
    }

    public void setInit() {
       
        System.err.println("init: "+chatID + " : "+chatName);
    }

    public Chatroom getSelectedChatroom() {
        return selectedChatroom;
    }

    public String setSelectedChatroom(Chatroom selectedChatroom) {
        this.selectedChatroom = selectedChatroom;
        return "chatRoomDetails";
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

}
