package vn.edu.ntu.phuocthai.danhbadienthoai.Controller;

import java.util.List;

import vn.edu.ntu.phuocthai.danhbadienthoai.Model.Contact;

public interface IContactController {
    public void insertContact(Contact contact);
    public void updateContact(Contact contact);
    public void deleteContact(Contact contact);
    public List<Contact> GetAllContact();
    public Contact FindcontactbyId(int id);
}
