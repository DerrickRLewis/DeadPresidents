package io.figure8.deadpresidents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    Button btn_ok, btn_cancel;
    List<President> presidentList;
    EditText et_presDate, et_presName,et_presImageURL;
    TextView tv_presId;
    int id;

    MyApplication myApplication = (MyApplication) this.getApplication();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        presidentList = myApplication.getPresidentList();
        btn_ok = findViewById(R.id.btn_Ok);
        btn_cancel = findViewById(R.id.btn_Cancel);
        et_presDate = findViewById(R.id.et_dateElection);
        et_presName = findViewById(R.id.et_preisdentName);
        et_presImageURL = findViewById(R.id.et_pictureURL);
        tv_presId = findViewById(R.id.tv_presidentidNumber);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        President president = null;

        if (id >= 0) {
            //edit president
            for (President p : presidentList) {
                if (p.getId() == id) {
                    president = p;
                }
            }
            et_presName.setText(president.getName());
            et_presDate.setText(String.valueOf(president.getDateOfElection()));
            et_presImageURL.setText(president.getImageURL());
            tv_presId.setText(String.valueOf(id));
        } else {

            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (id >= 0) {
                        //update
                        President updatedPresident = new President(id, et_presName.getText().toString(), Integer.parseInt(et_presDate.getText().toString()), et_presImageURL.getText().toString());
                        presidentList.set(id, updatedPresident);
                    } else {
                        //add new president
                        //create a President Object
                        int nextId = myApplication.getNextId();
                        President newPresident = new President(nextId, et_presName.getText().toString(), Integer.parseInt(et_presDate.getText().toString()), et_presImageURL.getText().toString());
                        //Add object to list
                        presidentList.add(newPresident);
                        myApplication.setNextId(nextId++);
                    }

                    //go back to main activity
                    Intent intent = new Intent(AddEditOne.this, AddEditOne.class);
                    startActivity(intent);
                }
            });
            btn_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(AddEditOne.this, AddEditOne.class);
                    startActivity(intent);
                }
            });


        }
    }}