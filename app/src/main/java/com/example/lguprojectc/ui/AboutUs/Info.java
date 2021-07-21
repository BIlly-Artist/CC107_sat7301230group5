package com.example.lguprojectc.ui.AboutUs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lguprojectc.R;

public class Info extends Fragment {

    ViewFlipper vfli;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.aboutus, container, false);

        vfli = (ViewFlipper) root.findViewById(R.id.flipper);


        int images[] = {R.drawable.gp1,R.drawable.gp3, R.drawable.gp6};

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