package vn.edu.ntu.phuocthai.danhbadienthoai.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Contact")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    int id;
    @NonNull
    String name;
    @NonNull
    String phonenum;
    @NonNull
    String address;
    @NonNull
    boolean farvorite;
    public Contact() {
    }

    public boolean isFarvorite() {
        return farvorite;
    }

    public void setFarvorite(boolean farvorite) {
        this.farvorite = farvorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(@NonNull String phonenum) {
        this.phonenum = phonenum;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }
}
