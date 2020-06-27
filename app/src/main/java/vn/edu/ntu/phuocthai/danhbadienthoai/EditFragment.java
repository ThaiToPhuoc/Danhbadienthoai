package vn.edu.ntu.phuocthai.danhbadienthoai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import vn.edu.ntu.phuocthai.danhbadienthoai.Controller.IContactController;
import vn.edu.ntu.phuocthai.danhbadienthoai.Model.Contact;

public class EditFragment extends Fragment {

    EditText editname, editphone, editaddress;
    CheckBox farvorite;
    Button btnsave, btnexit;
    Contact contact;
    int id;
    IContactController contactController;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        Bundle bundle = getArguments();
        id = bundle.getInt("id");
        addViews(view);
        addaction();
        return view;
    }

    private void addViews(View view) {
        editname = view.findViewById(R.id.edtname);
        editphone = view.findViewById(R.id.edtphonenumber);
        editaddress = view.findViewById(R.id.edtaddress);
        farvorite = view.findViewById(R.id.cbfarvorite);
        btnsave = view.findViewById(R.id.btnsave);
        btnexit = view.findViewById(R.id.btnexit);
        contactController = ((MainActivity)getActivity()).contactController;
        navController = NavHostFragment.findNavController(EditFragment.this);
        if (id != -1)
        {
            contact = contactController.FindcontactbyId(id);
            editname.setText(contact.getName().toString());
            editphone.setText(contact.getPhonenum().toString());
            editaddress.setText(contact.getAddress().toString());
            farvorite.setChecked(contact.isFarvorite());
        }
        else
        {
            contact = new Contact();
            editname.setText(" ");
            editphone.setText(" ");
            editaddress.setText(" ");
            farvorite.setChecked(false);
        }
    }

    private void addaction(){
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id == -1){
                    contact.setName(editname.getText().toString());
                    contact.setPhonenum(editphone.getText().toString());
                    contact.setAddress(editaddress.getText().toString());
                    contact.setFarvorite(farvorite.isChecked());
                    contactController.insertContact(contact);
                }
                else {
                    contact.setName(editname.getText().toString());
                    contact.setPhonenum(editphone.getText().toString());
                    contact.setAddress(editaddress.getText().toString());
                    contact.setFarvorite(farvorite.isChecked());
                    contactController.updateContact(contact);
                }
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_editFragment_to_contactfragment);
            }
        });
    }
}