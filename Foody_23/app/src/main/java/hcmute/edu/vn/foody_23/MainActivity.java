package hcmute.edu.vn.foody_23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.content.Intent;
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

        // KHỞI TẠO DATABASE nếu như Database chưa tồn tại
//        database = new Database(this,"Foody.sqlite",null,1);
//        database.QueryData("CREATE TABLE IF NOT EXISTS Province(Id INTEGER PRIMARY KEY AUTOINCREMENT,Ten VARCHAR(150))");
//        database.QueryData("CREATE TABLE IF NOT EXISTS Image(Id_Img INTEGER PRIMARY KEY AUTOINCREMENT,HinhAnh BLOB,Store_Id INTEGER REFERENCES Store(Id),Kieuhinhanh NVARCHAR(10))");
//        database.QueryData("CREATE TABLE IF NOT EXISTS Store(Id INTEGER PRIMARY KEY AUTOINCREMENT, Address VARCHAR (150),Name VARCHAR (30),Description VARCHAR (200),Province_Id INTEGER REFERENCES Province (Id),OpenTime NVARCHAR(10),Wifi_name NVARCHAR(30),Wifi_password NVARCHAR(10))");
//        database.QueryData("CREATE TABLE IF NOT EXISTS Menu_group(group_Id INTEGER PRIMARY KEY  AUTOINCREMENT,Store_Id INTEGER  REFERENCES Store (Id),group_name VARCHAR (50) )");
//        database.QueryData("CREATE TABLE IF NOT EXISTS Menu(Id INTEGER PRIMARY KEY AUTOINCREMENT,Address VARCHAR (150),group_id INTEGER  REFERENCES Menu_group (group_Id),TenMon VARCHAR (30), GiatTien DOUBLE)");
        //SeedingData();
//        PopulateData();
        // SET ADAPTER VÀO RECYCLER VIEW

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

    // THÊM CÁC DỮ LIỆU ĐẦU TIÊN VÀO CSDL
//    private void SeedingData()
//    {
//        // INSERT TỈNH THÀNH VÀO BẢNG PROVINCE
//        String tinh1 = "An Giang";
//        String tinh2 = "Bà Rịa - Vũng Tàu";
//        String tinh3 = "Bắc Giang";
//        String tinh4 = "Bắc Kạn";
//        String tinh5 = "Bạc Liêu";
//        String tinh6 = "Bắc Ninh";
//        String tinh7 = "Bến Tre";
//        String tinh8 = "Bình Định";
//        String tinh9 = "Bình Dương";
//        String tinh10 = "Bình Phước";
//        String tinh11 = "BÌnh Thuận";
//        String tinh12 = "Cà Mau";
//        String tinh13 = "Cao Bằng";
//        String tinh14 = "Đăk Lăk";
//        String tinh15 = "Đăk Nông";
//        String tinh16 = "Điện Biên";
//        String tinh17 = "Đồng Nai";
//        String tinh18 = "Đồng Tháp";
//        String tinh19 = "Gia Lai";
//        String tinh20 = "Hà Giang";
//        String tinh21 = "Hà Nam";
//        String tinh22 = "Hà Tĩnh";
//        String tinh23 = "Hải Dương";
//        String tinh24 = "Hậu Giang";
//        String tinh25 = "Hòa Bình";
//        String tinh26 = "Hưng Yên";
//        String tinh27 = "Khánh Hòa";
//        String tinh28 = "Kiên Giang";
//        String tinh29 = "Kon Tum";
//        String tinh30 = "Lai Châu";
//        String tinh31 = "Lâm Đồng";
//        String tinh32 = "Lạng Sơn";
//        String tinh33 = "Lào Cai";
//        String tinh34 = "Long An";
//        String tinh35 = "Nam Định";
//        String tinh36 = "Nghệ An";
//        String tinh37 = "Ninh Bình";
//        String tinh38 = "Ninh Thuận";
//        String tinh39 = "Phú Thọ";
//        String tinh40 = "Quảng Bình";
//        String tinh41 = "Quảng Nam";
//        String tinh42 = "Quảng Ngãi";
//        String tinh43 = "Quảng Ninh";
//        String tinh44 = "Quảng Trị";
//        String tinh45 = "Sóc Trăng";
//        String tinh46 = "Sơn La";
//        String tinh47 = "Tây Ninh";
//        String tinh48 = "Thái Bình";
//        String tinh49 = "Thái Nguyên";
//        String tinh50 = "Thanh Hóa";
//        String tinh51 = "Thừa Thiên Huế";
//        String tinh52 = "Tiền Giang";
//        String tinh53 = "Trà Vinh";
//        String tinh54 = "Tuyên Quang";
//        String tinh55 = "Vĩnh Long";
//        String tinh56 = "Vĩnh Phúc";
//        String tinh57 = "Yên Bái";
//        String tinh58 = "Phú Yên";
//        String tinh59 = "Cần Thơ";
//        String tinh60 = "Đà Nẵng";
//        String tinh61 = "Hải Phòng";
//        String tinh62 = "Hà Nội";
//        String tinh63 = "TP HCM";
//
//        String[] tinh = new String[]{tinh1, tinh2, tinh3, tinh4, tinh5, tinh6, tinh7, tinh8, tinh9, tinh10,
//                tinh11, tinh12, tinh13, tinh14, tinh15, tinh16, tinh17, tinh18, tinh19, tinh20,
//                tinh21, tinh22, tinh23, tinh24, tinh25, tinh26, tinh27, tinh28, tinh29, tinh30,
//                tinh31, tinh32, tinh33, tinh34, tinh35, tinh36, tinh37, tinh38, tinh39, tinh40,
//                tinh41, tinh42, tinh43, tinh44, tinh45, tinh46, tinh47, tinh48, tinh49, tinh50,
//                tinh51, tinh52, tinh53, tinh54, tinh55, tinh56, tinh57, tinh58, tinh59, tinh60,
//                tinh61, tinh62, tinh63};
//
//        int i =0;
//            while(i< tinh.length ) {
//                database.insert_Province(tinh[i]);
//                i++;
//            }
//      //INSERT CỬA HÀNG VÀO BẢNG STORE
//        List<Store> lstStore = new ArrayList<>();
//        lstStore.add(new Store(null,"24/3 Võ Văn Ngân","Bún bò cô Ba","Bún bò cô 3 ngon lắm",61,"8:00AM","CoBaBanBun","12345678"));
//        lstStore.add(new Store(null,"3/123 Ung Văn Khiêm","Cháo Vịt Thanh Đa","Cháo vịt ngon như cháo vịt",61,"8:00AM","ChaoZit","1234567"));
//        lstStore.add(new Store(null,"105 Nguyễn Gia Trí","Dooki","Bún bò cô 3 ngon lắm",61,"8:30AM","DOOKIVN","dooki45678"));
//        lstStore.add(new Store(null,"926 Cách Mạng Tháng 8","Bún bò cô Ba","Bún bò cô 3 ngon lắm",61,"8:00AM","CoBaBanBun","12345678"));
//        lstStore.add(new Store(null,"243 đường 30/4","Nem nướng Quận 6","Nem ngon thịt thật",61,"8:00AM","CoBaBanBun","12345678"));
//        lstStore.add(new Store(null,"241 Huỳnh tấn Phát, Quận 7 ","Bánh cuốn tây Hồ","Bánh cuốn tây Hồ ngon",61,"8:00AM","CoBaBanBun","12345678"));
//
//        int j =0;
//        while(j < lstStore.size() ) {
//            Store str = lstStore.get(j);
//            database.insert_Store(str);
//            j++;
//        }
//
//        // Insert ìnhh vào bảng Image
//        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.bunbohue);
//        database.insert_Img(ConvertToByteArray(bitmapDrawable),1,"thumb");
//        bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.canhbun);
//        database.insert_Img(ConvertToByteArray(bitmapDrawable),2,"thumb");
//        bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.chaovit);
//        database.insert_Img(ConvertToByteArray(bitmapDrawable),3,"thumb");
//        bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.comchay);
//        database.insert_Img(ConvertToByteArray(bitmapDrawable),4,"thumb");
//        bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.thealley);
//        database.insert_Img(ConvertToByteArray(bitmapDrawable),5,"thumb");
//        bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.bunbohue);
//        database.insert_Img(ConvertToByteArray(bitmapDrawable),6,"thumb");
//    }

//    private void PopulateData()
//    {
//        cursor = database.Load_all_store();
//        monAnList.clear();
//        if(cursor.getColumnCount() != 0)
//        {
//            int x = cursor.getColumnCount();
//            while(cursor.moveToNext())
//            {
//                String Desc = cursor.getString(1);
//                String Name = cursor.getString(2);
//                byte[] Img = cursor.getBlob(3);
//                MonAn monAn = new MonAn(Name,Desc,Img);
//                monAnList.add(monAn);
//            }
//        }
//        else
//        {
//            Toast.makeText(MainActivity.this,"Nothing",Toast.LENGTH_SHORT).show();
//        }
//    }

    private byte[] ConvertToByteArray(BitmapDrawable bitmapDrawable)
    {
        Bitmap bitmap = bitmapDrawable.getBitmap();
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArray);
        byte[] hinhAnh = byteArray.toByteArray();
        return hinhAnh;
    }

}

