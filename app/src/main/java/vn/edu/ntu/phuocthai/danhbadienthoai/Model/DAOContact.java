package vn.edu.ntu.phuocthai.danhbadienthoai.Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAOContact {
    @Insert
    public void insertContact(Contact...contacts);
    @Update
    public void updateContact(Contact...contacts);
    @Delete
    public void deleteContact(Contact...contacts);

    @Query("SELECT * FROM Contact")
    public List<Contact> getallContact();

    @Query("SELECT * FROM Contact WHERE id = :id")
    public Contact findContactbyID(int id);
}
