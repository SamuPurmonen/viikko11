package com.example.viikko11;

import java.util.ArrayList;

public class ContactStorage {

    ArrayList<Contact> yt = new ArrayList<>();
    private static ContactStorage contacts = null;

    public static ContactStorage getInstance(){

        if(contacts == null){
            contacts = new ContactStorage();

        }
        return contacts;
    }

    public ArrayList<Contact> getContacts() {
        /*antaa sisältämänsä listan*/
        return yt;

    }

    public void addContact(Contact yhteystieto){
        //lisää kontantin listaan
        yt.add(yhteystieto);
        System.out.println("kontakti luotu contactstoragessa");

    }

    public void removeContact(String id){
        //poistaa annetun indeksin contacts listalta
        int i = 0;
        for (Contact c : yt){
            if (c.getNumber().equals(id)){
                break;
            }
            i++;
        }
        yt.remove(i);
    }
}
