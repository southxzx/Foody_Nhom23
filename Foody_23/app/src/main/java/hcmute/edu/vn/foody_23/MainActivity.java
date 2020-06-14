package hcmute.edu.vn.foody_23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtTimKiem;
    List<MonAn> monAnList = new ArrayList<>();
    TextView txtTinhThanh;
    TextView txtThucDon;
    Cursor cursor;

    public static Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        monAnList = DatabaseAccess.getInstance(MainActivity.this).getMonAn();
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this,monAnList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recycleViewAdapter);

        // CÁC SỰ KIỆN CLICK
        txtTinhThanh = findViewById(R.id.txtTinhThanh);
        txtTinhThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TinhThanhActivity.class);
                startActivity(intent);
            }
        });
        edtTimKiem = (EditText) findViewById(R.id.search_Index);
        edtTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}

