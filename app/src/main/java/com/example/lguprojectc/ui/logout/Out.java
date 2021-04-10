package com.example.lguprojectc.ui.logout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.lguprojectc.R;
import com.example.lguprojectc.Route;
import com.example.lguprojectc.SplashActivity;

public class Out extends Fragment {
    CardView c1, c2, c3;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.logout, container, false);

        Intent intent = new Intent (getActivity(), SplashActivity.class);
        startActivity(intent);
        getActivity().finish();

        Toast.makeText(getActivity(), "LOGGING OUT", Toast.LENGTH_LONG).show();

        return root;
    }
}