package vn.edu.ntu.phuocthai.danhbadienthoai.Controller;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

import vn.edu.ntu.phuocthai.danhbadienthoai.Model.AppDatabase;
import vn.edu.ntu.phuocthai.danhbadienthoai.Model.Contact;
import vn.edu.ntu.phuocthai.danhbadienthoai.Model.DAOContact;

public class ContactControllerDB implements IContactController{
    DAOContact DAOcontact;
    AppDatabase Database;

    public ContactControllerDB(Context context) {
        Database = Room.databaseBuilder(context,AppDatabase.class,"appdata")
                .allowMainThreadQueries().build();
        DAOcontact = Database.getDAOContact();
    }

    @Override
    public void insertContact(Contact contact) {
        DAOcontact.insertContact(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        DAOcontact.updateContact(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        DAOcontact.deleteContact(contact);
    }

    @Override
    public List<Contact> GetAllContact() {
        return DAOcontact.getallContact();
    }

    @Override
    public Contact FindcontactbyId(int id) {
        return DAOcontact.findContactbyID(id);
    }
}
