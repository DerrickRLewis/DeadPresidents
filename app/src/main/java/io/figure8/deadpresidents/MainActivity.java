package io.figure8.deadpresidents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Presidents Apps";
    Button btn_addOne;
    List<President> presidentList = new ArrayList<President>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillPresidentList();
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

    private void fillPresidentList() {
        President p0 = new President(0, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/160px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1, "Ronald Reagan", 1981, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Official_Portrait_of_President_Reagan_1981.jpg/165px-Official_Portrait_of_President_Reagan_1981.jpg");
        President p2 = new President(2, "Abraham Lincoln", 1861, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Abraham_Lincoln_O-77_matte_collodion_print.jpg/160px-Abraham_Lincoln_O-77_matte_collodion_print.jpg");
        President p3 = new President(3, "Ulysses S. Grant", 1869, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Ulysses_S_Grant_by_Brady_c1870-restored.jpg/160px-Ulysses_S_Grant_by_Brady_c1870-restored.jpg");
        President p4 = new President(4, "Theodore Roosevelt", 1901, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/President_Roosevelt_-_Pach_Bros.jpg/160px-President_Roosevelt_-_Pach_Bros.jpg");
        President p5 = new President(5, "Franklin D. Roosevelt", 1933, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/FDR_in_1933_%281%29.jpg/160px-FDR_in_1933_%281%29.jpg");
        President p6 = new President(6, "John F. Kennedy", 1961, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/John_F._Kennedy%2C_White_House_color_photo_portrait.jpg/160px-John_F._Kennedy%2C_White_House_color_photo_portrait.jpg");
        President p7 = new President(7, "Lyndon B. Johnson", 1963, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/37_Lyndon_Johnson_3x4.jpg/160px-37_Lyndon_Johnson_3x4.jpg");
        President p8 = new President(8, "Richard Nixon", 1969, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Richard_Nixon_presidential_portrait.jpg/160px-Richard_Nixon_presidential_portrait.jpg");
        President p9 = new President(9, "Dwight D. Eisenhower", 1953, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Dwight_D._Eisenhower%2C_official_photo_portrait%2C_May_29%2C_1959.jpg/160px-Dwight_D._Eisenhower%2C_official_photo_portrait%2C_May_29%2C_1959.jpg");

        presidentList.addAll(Arrays.asList(new President[]{p0,p1,p2,p3,p4,p5,p6,p7,p8,p9}));
    }
}