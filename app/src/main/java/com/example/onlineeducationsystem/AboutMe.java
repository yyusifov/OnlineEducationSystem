package com.example.onlineeducationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class AboutMe extends Fragment {
    private Button send;

    private EditText subject, message;

    public AboutMe() {
        // Required empty public constructor
    }

    public static AboutMe newInstance() {
        AboutMe fragment = new AboutMe();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_me, container, false);

        send = view.findViewById(R.id.send_button);

        subject = view.findViewById(R.id.subject_text);

        message = view.findViewById(R.id.message_text);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(message.getText().toString().isEmpty() || subject.getText().toString().isEmpty())) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822"); // MIME type for email
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"yadigaryusifov1@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());

                    try {
                        startActivity(Intent.createChooser(intent, "Choose an email client"));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(requireContext(), "No email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                } else if(subject.getText().toString().isEmpty()){
                    Toast.makeText(requireContext(), "Subject is empty!", Toast.LENGTH_SHORT).show();
                } else if (message.getText().toString().isEmpty()) {
                    Toast.makeText(requireContext(), "Message is empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}