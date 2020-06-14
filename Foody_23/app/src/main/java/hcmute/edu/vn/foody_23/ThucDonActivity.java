package hcmute.edu.vn.foody_23;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThucDonActivity extends AppCompatActivity {
    ExpandableListView expandableThucAn;
    List<String> listdataHeader;
    HashMap<String, List<String>> listdataChild;
    ThucDonExpandableAdapter thucDonExpandableAdapter;
    ImageView imageback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xem_thuc_don);
        AddFood();
        thucDonExpandableAdapter = new ThucDonExpandableAdapter(this,listdataHeader,listdataChild);
        expandableThucAn.setAdapter(thucDonExpandableAdapter);
    }

    private void AddFood() {
        expandableThucAn = (ExpandableListView) findViewById(R.id.expandlelistview_thuc_don);
        listdataHeader = new ArrayList<String>();
        listdataChild = new HashMap<String, List<String>>();

        listdataHeader.add("Bò Mỹ nhúng ớt");
        listdataHeader.add("Bún đậu");

        List<String> BoMynhungot = new ArrayList<String>();
        BoMynhungot.add("Bò mỹ nhúng ớt nhỏ");
        BoMynhungot.add("Bò mỹ nhúng ớt vừa");
        BoMynhungot.add("Bò mỹ nhúng ớt lớn");

        List<String> BunDau = new ArrayList<String>();
        BunDau.add("Bún đậu nhỏ");
        BunDau.add("Bún đậu lớn");
        BunDau.add("Bún đậu vừa");

        listdataChild.put(listdataHeader.get(0),BoMynhungot);
        listdataChild.put(listdataHeader.get(1),BunDau);
    }
}
