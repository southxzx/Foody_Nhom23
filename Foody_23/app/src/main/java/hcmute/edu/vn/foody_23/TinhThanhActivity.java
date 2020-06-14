package hcmute.edu.vn.foody_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TinhThanhActivity extends AppCompatActivity {

    ListView listView;
    TextView txtHuyTinhThanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chon_tinh_thanh);

        listView = findViewById(R.id.listTinhThanh);

        txtHuyTinhThanh = findViewById(R.id.txtHuyTinhThanh);
        txtHuyTinhThanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TinhThanhActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        String tinh1 = "An Giang";
        String tinh2 = "Bà Rịa - Vũng Tàu";
        String tinh3 = "Bắc Giang";
        String tinh4 = "Bắc Kạn";
        String tinh5 = "Bạc Liêu";
        String tinh6 = "Bắc Ninh";
        String tinh7 = "Bến Tre";
        String tinh8 = "Bình Định";
        String tinh9 = "Bình Dương";
        String tinh10 = "Bình Phước";
        String tinh11 = "BÌnh Thuận";
        String tinh12 = "Cà Mau";
        String tinh13 = "Cao Bằng";
        String tinh14 = "Đăk Lăk";
        String tinh15 = "Đăk Nông";
        String tinh16 = "Điện Biên";
        String tinh17 = "Đồng Nai";
        String tinh18 = "Đồng Tháp";
        String tinh19 = "Gia Lai";
        String tinh20 = "Hà Giang";
        String tinh21 = "Hà Nam";
        String tinh22 = "Hà Tĩnh";
        String tinh23 = "Hải Dương";
        String tinh24 = "Hậu Giang";
        String tinh25 = "Hòa Bình";
        String tinh26 = "Hưng Yên";
        String tinh27 = "Khánh Hòa";
        String tinh28 = "Kiên Giang";
        String tinh29 = "Kon Tum";
        String tinh30 = "Lai Châu";
        String tinh31 = "Lâm Đồng";
        String tinh32 = "Lạng Sơn";
        String tinh33 = "Lào Cai";
        String tinh34 = "Long An";
        String tinh35 = "Nam Định";
        String tinh36 = "Nghệ An";
        String tinh37 = "Ninh Bình";
        String tinh38 = "Ninh Thuận";
        String tinh39 = "Phú Thọ";
        String tinh40 = "Quảng Bình";
        String tinh41 = "Quảng Nam";
        String tinh42 = "Quảng Ngãi";
        String tinh43 = "Quảng Ninh";
        String tinh44 = "Quảng Trị";
        String tinh45 = "Sóc Trăng";
        String tinh46 = "Sơn La";
        String tinh47 = "Tây Ninh";
        String tinh48 = "Thái Bình";
        String tinh49 = "Thái Nguyên";
        String tinh50 = "Thanh Hóa";
        String tinh51 = "Thừa Thiên Huế";
        String tinh52 = "Tiền Giang";
        String tinh53 = "Trà Vinh";
        String tinh54 = "Tuyên Quang";
        String tinh55 = "Vĩnh Long";
        String tinh56 = "Vĩnh Phúc";
        String tinh57 = "Yên Bái";
        String tinh58 = "Phú Yên";
        String tinh59 = "Cần Thơ";
        String tinh60 = "Đà Nẵng";
        String tinh61 = "Hải Phòng";
        String tinh62 = "Hà Nội";
        String tinh63 = "TP HCM";

        String[] tinh = new String[]{tinh1, tinh2, tinh3, tinh4, tinh5, tinh6, tinh7, tinh8, tinh9, tinh10,
                tinh11, tinh12, tinh13, tinh14, tinh15, tinh16, tinh17, tinh18, tinh19, tinh20,
                tinh21, tinh22, tinh23, tinh24, tinh25, tinh26, tinh27, tinh28, tinh29, tinh30,
                tinh31, tinh32, tinh33, tinh34, tinh35, tinh36, tinh37, tinh38, tinh39, tinh40,
                tinh41, tinh42, tinh43, tinh44, tinh45, tinh46, tinh47, tinh48, tinh49, tinh50,
                tinh51, tinh52, tinh53, tinh54, tinh55, tinh56, tinh57, tinh58, tinh59, tinh60,
                tinh61, tinh62, tinh63};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tinh);
        listView.setAdapter(arrayAdapter);

    }
}
