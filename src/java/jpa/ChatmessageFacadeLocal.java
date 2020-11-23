/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Chatmessage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface ChatmessageFacadeLocal {

    void create(Chatmessage chatmessage);

    void edit(Chatmessage chatmessage);

    void remove(Chatmessage chatmessage);

    Chatmessage find(Object id);

    List<Chatmessage> findAll();

    List<Chatmessage> findRange(int[] range);

    int count();
    List<Chatmessage> findRoomMessages(int chatRoomID);
}
