/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Chatmessage;
import entities.Chatroom;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import jpa.ChatmessageFacade;
import jpa.ChatmessageFacadeLocal;
import jpa.ChatroomFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class UpdateChatroomSettingsController_EJB {

    @Inject
    private ChatroomFacadeLocal chatRoomFacade;
@Inject
private ChatmessageFacadeLocal chatMessageFacade;
    private int myID;
    private int chatID;
    private String passwordRoh;
    private String passwordCrypted;
    private Boolean isPrivate;
    private Boolean isPublic;
    private String chatName;
    private Chatroom selectedRoom;
    private String settings;
    private Boolean bolSettings;

    public void test() {
        setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
        setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
        setMyID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("myID")));
        if (myID == getSelectedRoom().getCreatorID()) {
            setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
            setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
            System.err.println("room im test? " + getSelectedRoom().getName() + getIsPrivate());
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aou´re not allowed to change settings", "Forbidden"));

        }

    }
public void updatePrivate(){
 setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
        setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
        setMyID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("myID")));
        if (myID == getSelectedRoom().getCreatorID()) {
            setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
            setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
            System.err.println("room set private? " + getSelectedRoom().getName() + getIsPrivate());
        Chatroom myRoom=getSelectedRoom();
            myRoom.setPassword(getPasswordCrypted());
        myRoom.setIsPrivate(true);
        myRoom.setIsPublic(false);
            
        chatRoomFacade.edit(myRoom);
        System.err.println("selected room: "+getSelectedRoom().getName() + " "+getSelectedRoom().getPassword());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Chatroom updated", "Private and Password set"));

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "You´re not allowed to change settings", "Forbidden"));

        }
}
public void updatePublic(){
 setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
        setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
        setMyID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("myID")));
        if (myID == getSelectedRoom().getCreatorID()) {
            setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
            setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
            System.err.println("room set public? " + getSelectedRoom().getName() + getIsPrivate());
        Chatroom myRoom=getSelectedRoom();
            myRoom.setPassword(null);
        myRoom.setIsPrivate(false);
        myRoom.setIsPublic(true);
        chatRoomFacade.edit(myRoom);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Chatroom updated", "Room set to Public"));

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "You´re not allowed to change settings", "Forbidden"));

        }
}
public void removeRoom(int roomID){
    
    List<Chatmessage>toDeleteList=new ArrayList<>();
    try{
    chatRoomFacade.remove(chatRoomFacade.find(roomID));
    toDeleteList=chatMessageFacade.findRoomMessages(roomID);
    for(Chatmessage cm:toDeleteList){
    chatMessageFacade.remove(cm);
    }
    FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Room "+roomID +" deletd",""));
    }catch(NullPointerException np){
     FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Deletion failed",""));
    }
    
}
    public Chatroom getSelectedRoom() {
        return chatRoomFacade.find(chatID);
    }

    public void setSelectedRoom(Chatroom selectedRoom) {
        this.selectedRoom = selectedRoom;
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

    public int getMyID() {
        return myID;
    }

    public void setMyID(int myID) {
        this.myID = myID;
    }

    public String getPasswordRoh() {
        return passwordRoh;
    }

    public void setPasswordRoh(String passwordRoh) {
        this.passwordRoh = passwordRoh;
    }

    public String getPasswordCrypted() {
        return passwordCrypted;
    }

    public void setPasswordCrypted(String passwordRoh) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.passwordCrypted = passwordRoh;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
        setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
        setMyID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("myID")));
        setSelectedRoom(chatRoomFacade.find(chatID));
        System.err.println("private sollte");
        this.isPrivate = isPrivate;
        if (this.isPrivate == true) {
            setIsPublic(false);
        }
    }

    public String getSettings() {
        return settings;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
        if (this.isPublic == true) {
            setIsPrivate(false);
        }
    }

    public void setSettings(String settings) {
        System.err.println("settingsString " + settings);
        this.settings = settings;
        if (settings.equals("1")) {
            setIsPrivate(true);
            setBolSettings(true);
        } else if (settings.equals("2")) {
            setIsPublic(true);
            setBolSettings(true);
        } else if (settings.equals("0")) {
            setBolSettings(false);
        }
    }

    public void setRoomPassword() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        setChatName(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatName"));
        setChatID(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("chatID")));
        setPasswordCrypted(passwordRoh);
        System.err.println("passwort: "+passwordCrypted);
    }

    public Boolean getBolSettings() {
        return bolSettings;
    }

    public void setBolSettings(Boolean bolSettings) {
        this.bolSettings = bolSettings;
    }

}
