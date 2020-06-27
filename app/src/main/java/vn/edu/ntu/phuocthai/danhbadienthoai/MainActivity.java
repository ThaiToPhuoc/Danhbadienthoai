package vn.edu.ntu.phuocthai.danhbadienthoai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.edu.ntu.phuocthai.danhbadienthoai.Controller.ContactControllerDB;
import vn.edu.ntu.phuocthai.danhbadienthoai.Controller.IContactController;

public class MainActivity extends AppCompatActivity {

    IContactController contactController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactController = new ContactControllerDB(this);
    }
}