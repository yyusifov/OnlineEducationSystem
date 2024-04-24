package com.example.onlineeducationsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlineeducationsystem.model.UserGender;
import com.example.onlineeducationsystem.model.UserInformation;
import com.example.onlineeducationsystem.util.UserViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

public class MyProfile extends Fragment {

    public MyProfile() {
        // Required empty public constructor
    }

    public static MyProfile newInstance() {
        MyProfile fragment = new MyProfile();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        EditText phone_number = view.findViewById(R.id.phone_number_text);

        EditText e_mail = view.findViewById(R.id.email_text);

        EditText password = view.findViewById(R.id.password_text);

        EditText confirm_password = view.findViewById(R.id.confirm_password_text);

        Button save_button = view.findViewById(R.id.button_save_for_ui);

        TextView username = view.findViewById(R.id.username_text_p);
        
        EditText fullname = view.findViewById(R.id.fullname_text);

        EditText gender = view.findViewById(R.id.gender_text);

        EditText birthdate = view.findViewById(R.id.birth_date_text);

        UserViewModel userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()).create(UserViewModel.class);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userViewModel.getUserInformation(getArguments().getInt("user_id", -5)).observe(requireActivity(), new Observer<UserInformation>() {
                    @Override
                    public void onChanged(UserInformation userInformation) {
                        if(password.getText().toString().equals(confirm_password.getText().toString()) && (e_mail.getText().toString().endsWith("@gmail.com") || e_mail.getText().toString().endsWith("@ada.edu.az")) && (phone_number.getText().toString().startsWith("(+994) 70") || phone_number.getText().toString().startsWith("(+994) 55") || phone_number.getText().toString().startsWith("(+994) 77") || phone_number.getText().toString().startsWith("(+994) 50"))){

                            userInformation.setUser_password(password.getText().toString());

                            userInformation.setUser_email(e_mail.getText().toString());

                            userInformation.setPhone_number(phone_number.getText().toString());

                            userInformation.setUpdate_date(new Date().getTime());

                            UserViewModel.updateUserInformation(userInformation);
                        }
                        else {
                            String problem = "";
                            if(!password.getText().toString().equals(confirm_password.getText().toString())) {
                                problem += "Passwords do not match!\n";
                            }
                            else if(!(e_mail.getText().toString().endsWith("@gmail.com") || e_mail.getText().toString().endsWith("@ada.edu.az"))){
                                problem += "E-mail format is not correct!\n";
                            }
                            else if(!((phone_number.getText().toString().startsWith("(+994) 70") || phone_number.getText().toString().startsWith("(+994) 55") || phone_number.getText().toString().startsWith("(+994) 77") || phone_number.getText().toString().startsWith("(+994) 50")))){
                                problem += "Phone number format is not correct!";
                            }
                            Snackbar.make(password, problem, Snackbar.LENGTH_LONG).show();

                        }

                        confirm_password.setText("");
                    }
                });
            }
        });

        userViewModel.getUserInformation(getArguments().getInt("user_id", -5)).observe(requireActivity(), new Observer<UserInformation>() {
            @Override
            public void onChanged(UserInformation userInformation) {

                e_mail.setText(userInformation.getUser_email());

                password.setText(userInformation.getUser_password());

                username.setText(userInformation.getUser_name());
                
                fullname.setText(String.format("%s %s", userInformation.getUser_firstname(), userInformation.getUser_surname()));

                phone_number.setText(userInformation.getPhone_number());

                userViewModel.getUserGender(userInformation.getGender_id()).observe(requireActivity(), new Observer<UserGender>() {
                    @Override
                    public void onChanged(UserGender userGender) {
                        gender.setText(userGender.getGender_text());
                    }
                });

                birthdate.setText(userInformation.getBirth_date());
            }
        });

        return view;
    }

}