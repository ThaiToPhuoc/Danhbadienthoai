package vn.edu.ntu.phuocthai.danhbadienthoai.Model;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DAOContact getDAOContact();
}
