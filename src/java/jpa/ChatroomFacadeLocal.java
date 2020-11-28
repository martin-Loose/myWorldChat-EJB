/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Chatroom;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface ChatroomFacadeLocal {

    void create(Chatroom chatroom);

    void edit(Chatroom chatroom);

    void remove(Chatroom chatroom);

    Chatroom find(Object id);

    List<Chatroom> findAll();

    List<Chatroom> findRange(int[] range);

    int count();
 Chatroom existRoom (String name);
 List<Chatroom> findRoomByName(String name);
 List<Chatroom> findRoomByStartString(String searchString);
 List<Chatroom> findRoomByNameContains(String searchString);
 List<Chatroom> findRoomByThemeContains(String searchString);
 List<Chatroom> findRoomByTheme(String searchString);
 List<Chatroom> findMyCreatedRooms(int  searchID);
 List<Chatroom> findRoomsWhereImIn(int  searchID);//dropped:when window unload -> remove userID from chat (the plan)
List<Chatroom> findPublicRooms(boolean  isPublic);
}
