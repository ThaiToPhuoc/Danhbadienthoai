package vn.edu.ntu.phuocthai.danhbadienthoai;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.phuocthai.danhbadienthoai.Controller.IContactController;
import vn.edu.ntu.phuocthai.danhbadienthoai.Model.Contact;

public class Contactfragment extends Fragment {

    List<Contact> contactList = new ArrayList<>();
    IContactController contactController;
    ContactAdapter adapter;
    RecyclerView recyclerView;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contactfragment, container, false);
        addview(view);
        addaction();
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.my_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        showedit();
        return super.onOptionsItemSelected(item);
    }

    private void showedit() {
        Bundle bundle = new Bundle();
        bundle.putInt("id",-1);
        navController.navigate(R.id.action_contactfragment_to_editFragment,bundle);
    }

    private void addaction() {
    }

    private void addview(View view) {
        recyclerView = view.findViewById(R.id.rcvlistcontact);
        contactController = ((MainActivity)getActivity()).contactController;
        contactList = contactController.GetAllContact();
        adapter = new ContactAdapter(contactList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        navController = NavHostFragment.findNavController(Contactfragment.this);
    }

    public class  ContactViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtname, txtphonenumber, txtaddress;
        ImageView imgedit, imgdelete, imgfarvorite;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtname);
            txtphonenumber = itemView.findViewById(R.id.txtphonenum);
            txtaddress = itemView.findViewById(R.id.txtaddress);
            imgedit = itemView.findViewById(R.id.imgedit);
            imgdelete = itemView.findViewById(R.id.imgdelete);
            imgfarvorite = itemView.findViewById(R.id.imgfarvorite);
        }

        public void bind(Contact contact)
        {
            txtname.setText(contact.getName());
            txtphonenumber.setText(contact.getPhonenum());
            txtaddress.setText(contact.getAddress());

            if (contact.isFarvorite()){
                imgfarvorite.setImageResource(R.drawable.ic_action_favorite);
            }
            else {
                imgfarvorite.setImageResource(R.drawable.ic_action_favorite_border);
            }

        }
    }

    public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>{
        List<Contact> contactList = new ArrayList<>();

        public ContactAdapter(List<Contact> contactList) {
            this.contactList = contactList;
        }

        @NonNull
        @Override
        public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.contact,parent,false);
            return new ContactViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactViewHolder holder, final int position) {
            holder.bind(contactList.get(position));
            holder.imgedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("id",contactList.get(position).getId());
                    navController.navigate(R.id.action_contactfragment_to_editFragment,bundle);
                }
            });
            holder.imgdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    contactController.deleteContact(contactList.get(position));
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    if (Build.VERSION.SDK_INT >= 26) {
                        ft.setReorderingAllowed(false);
                    }
                    ft.detach(Contactfragment.this).attach(Contactfragment.this).commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return contactList.size();
        }
    }
}