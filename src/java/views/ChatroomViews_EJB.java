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

    private List<Chatroom> myNewListOfRooms;
    //   private List<Chatroom> myNewListOfPrivateRooms;
    private String chatName;
    private int chatID;
    private Chatroom selectedChatroom;
    private boolean toShow;
    private String searchString;
    @Inject
    private ChatroomFacadeLocal chatroomFacade;

    public void senden() {
        setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
        setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
        setSelectedChatroom(chatroomFacade.find(chatID));
    }

    public List<Chatroom> getMyNewListOfRooms() {
        myNewListOfRooms = new ArrayList<>();
        try {
            if (isToShow() == false) {
                myNewListOfRooms = chatroomFacade.findAll();
            } else if (isToShow() == true) {
                myNewListOfRooms = chatroomFacade.findRoomByNameContains(searchString);
            }

            return myNewListOfRooms;
        } catch (NullPointerException np) {

        }
        return myNewListOfRooms;
    }

    public void findbyStart() {
        if (getSearchString().isEmpty()) {
            setToShow(false);
        } else {
            setToShow(true);
        }
        getMyNewListOfRooms();
    }

    public void setMyNewListOfRooms(List<Chatroom> myNewListOfRooms) {
        this.myNewListOfRooms = myNewListOfRooms;
    }

    public String getInit() {
        return chatName;
    }

    public void setInit() {

        System.err.println("init: " + chatID + " : " + chatName);
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

    public boolean isToShow() {
        return toShow;
    }

    public void setToShow(boolean toShow) {
        this.toShow = toShow;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

}
