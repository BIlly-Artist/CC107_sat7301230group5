package com.example.lguprojectc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ActionMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lguprojectc.ui.location.CardviewActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

public class Contact extends AppCompatActivity {

   private ImageView thumbnail;
 private Button call;
  private TextView contactTv;
    private TextView Cp;
    String cpp;
  private FloatingActionButton addFab;
  private  static int CONTACT_PERMISSION_CODE = 1;
    private  static int CONTACT_PICK_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

         call = findViewById(R.id.etcall);
        thumbnail = findViewById(R.id.thumbnail);
        contactTv = findViewById(R.id.contactTv);
        addFab = (findViewById(R.id.addFab));
        Cp = (findViewById(R.id.TvPhone));




        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              cpp = Cp.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + cpp));





                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Contact.this, "PLease Grand Permission", Toast.LENGTH_LONG).show();
                    requestPermissions();
                } else {
                    startActivity(intent);

                }


            }
        }
        );





        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkContactPermission()){
                    pickContactIntent();
                }else {

                    requestContactPermission();
                }
            }
        });


    }

    private  boolean checkContactPermission(){

        boolean result = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS) == (PackageManager.PERMISSION_GRANTED);

      return  result; // dito nakikita kung if true of false ang granted nya
    }


    private  void  requestContactPermission(){
        String[] permission = {Manifest.permission.READ_CONTACTS};
        ActivityCompat.requestPermissions(this, permission, CONTACT_PERMISSION_CODE);
    }


    private  void  pickContactIntent(){
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, CONTACT_PICK_CODE);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //hadle permission result
        if(requestCode == CONTACT_PERMISSION_CODE){
            if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //permission na pwede mag pick sa contact
                pickContactIntent();


            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();

            }
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // hanlde intent result
        if(resultCode == RESULT_OK){
            //calls when user click a contact from list
            if(requestCode == CONTACT_PICK_CODE){
                contactTv.setText("");

                Cursor cursur1 , cursor2;

                Uri uri = data.getData();
                cursur1 = getContentResolver().query(uri, null, null, null, null);
                 if(cursur1.moveToFirst()){
                     String contactId = cursur1.getString(cursur1.getColumnIndex(ContactsContract.Contacts._ID));
                     String contactName = cursur1.getString(cursur1.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                     String contactThumnail = cursur1.getString(cursur1.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI));
                     String idResults = cursur1.getString(cursur1.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                     int idResultHold = Integer.parseInt(idResults);

                     contactTv.append("ID: "+contactId);
                     contactTv.append("\nName: "+contactName);



                     if (idResultHold == 1){
                         cursor2 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                 ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = "+contactId,
                                 null,
                                 null

                         );
                         while (cursor2.moveToNext()){
                             String contactNumber = cursor2.getString(cursor2.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


                             Cp.append(contactNumber);




                             //checker off image if meron o wala
                             if(contactThumnail != null){
                                 thumbnail.setImageURI(Uri.parse(contactThumnail));
                             }else {
                                 thumbnail.setImageResource(R.drawable.ic_baseline_contact_phone_24);
                             }

                         }

                         cursor2.close();


                     }
                     cursur1.close();
                 }
            }
        }else {
            Toast.makeText(this,"Invalid",Toast.LENGTH_SHORT).show();


        }


    }





    private void requestPermissions() {

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 1);
    }

}
