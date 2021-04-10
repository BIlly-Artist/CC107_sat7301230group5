package com.example.lguprojectc.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lguprojectc.R;

public class Home extends Fragment {
    TextView textView;
    ViewFlipper vfli;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        vfli = (ViewFlipper) root.findViewById(R.id.flipper);

        textView = root.findViewById(R.id.user);
        String uname = getActivity().getIntent().getStringExtra("Keyname");
        textView.setText(uname);


        int images[] = {R.drawable.home1,R.drawable.home2,R.drawable.home3,R.drawable.home4};

        for (int i = 0; i < images.length;i++){
            flipperImages(images[i]);

        }


        for (int image: images)
            flipperImages(image);

        return root;
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);
        vfli.addView(imageView);
        vfli.setFlipInterval(3000);
        vfli.setAutoStart(true);

        //animation
        vfli.setInAnimation(getActivity(), android.R.anim.slide_in_left);
        vfli.setOutAnimation(getActivity(), android.R.anim.slide_out_right);


    }
}