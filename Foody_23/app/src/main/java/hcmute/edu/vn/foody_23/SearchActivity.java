package hcmute.edu.vn.foody_23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    CardView cardView;
    List<CuaHang> CuaHangList;
    EditText edtTimKiem;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        CuaHangList = new ArrayList<>();
        CuaHangList.add(new CuaHang("Bún Bò Huế Minh Hiếu","8","4/7 XVNT, Quận BT","4.5KM","Quán ăn","19","32",R.drawable.bunbohue));
        CuaHangList.add(new CuaHang("Bún Mắm Mãi Mặn","8","2/8 D2, Quận BT","4.5KM","Quán ăn","19","32",R.drawable.canhbun));
        CuaHangList.add(new CuaHang("Cháo Gà Cẫm Lan","8","78 D5, Quận BT","4.5KM","Quán ăn","19","32",R.drawable.chaovit));
        CuaHangList.add(new CuaHang("Cháo Vịt Thanh Đa","8","234/78 D1, Quận 9","4.5KM","Quán ăn","19","32",R.drawable.comchay));
        CuaHangList.add(new CuaHang("Xúc xích Ponie","8","2 đường 3/2, Quận 10","4.5KM","Quán ăn","19","32",R.drawable.highland));
        CuaHangList.add(new CuaHang("Trà Sữa Nguyễn Huệ","8","24/8  Nguyễn Huệ, Quận 1","4.5KM","Quán ăn","19","32",R.drawable.thealley));
        CuaHangList.add(new CuaHang("Hủ Tiếu SPKT","8","4/78 Quang Trung, Quận TD","4.5KM","Quán ăn","19","32",R.drawable.comchay));
        CuaHangList.add(new CuaHang("Bánh Tráng Trộn Cát Thy","8","4/7 Thủ Thiêm, Quận 2","4.5KM","Quán ăn","19","32",R.drawable.chaovit));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ResultRecyclerView);
        SeachResultRecycleViewAdapter recycleViewAdapter = new SeachResultRecycleViewAdapter(SearchActivity.this,CuaHangList);
        recyclerView.setLayoutManager(new GridLayoutManager(SearchActivity.this,1));
        recyclerView.setAdapter(recycleViewAdapter);

        edtTimKiem = (EditText) findViewById(R.id.searchBox);
        backBtn = (ImageView)  findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,int count) {
                if(!s.equals(""))
                {
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ResultRecyclerView);
                    SeachResultRecycleViewAdapter recycleViewAdapter = new SeachResultRecycleViewAdapter(SearchActivity.this,CuaHangList);
                    recyclerView.setLayoutManager(new GridLayoutManager(SearchActivity.this,1));
                    recyclerView.setAdapter(recycleViewAdapter);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,int after) {

            }

            public void afterTextChanged(Editable s) {

            }

        });
    }
}
