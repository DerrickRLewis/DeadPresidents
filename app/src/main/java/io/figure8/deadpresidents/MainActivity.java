package io.figure8.deadpresidents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Presidents Apps";
    Button btn_addOne;
    Menu menu;
    MyApplication myApplication = (MyApplication) this.getApplication();
    List<President> presidentList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presidentList = myApplication.getPresidentList();

        Log.d(TAG, "onCreate: "+ presidentList.toString());
        Toast.makeText(this,"president count =" + presidentList.size(),Toast.LENGTH_SHORT).show();

        btn_addOne = findViewById(R.id.btn_addOne);

        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEditOne.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.lv_presidentList);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(presidentList,MainActivity.this);
        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_aToz:
                //sort a to z
                Toast.makeText(myApplication,"Sorting A to Z ",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_zToa:
                Toast.makeText(myApplication,"Sorting Z to A ",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_dateAscending:
                Toast.makeText(myApplication,"Sorting date ascending",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_dateDescending:
                Toast.makeText(myApplication,"Sorting date descending ",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}