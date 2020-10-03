package id.primadev.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements PointAdapter.OnContactClickListener {

    public RecyclerView rv;
    public PointAdapter pointAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Point> listPoint = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rvPoint);
        daftarContact();


        pointAdapter = new PointAdapter(listPoint);
        pointAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(pointAdapter);
        rv.setLayoutManager(layoutManager);

    }

    @Override
    public void onClick(View view, int position) {
        Point point = listPoint.get(position);
        Toast.makeText(this, "BEST CLUB "+ point.getName(), Toast.LENGTH_LONG)
                .show();
    }

    private void daftarContact(){
        listPoint.add(new Point("CLS Knights Surabaya",
                "102018308",
                "https://upload.wikimedia.org/wikipedia/en/b/b3/CLS_Knights_logo.png"));

        listPoint.add(new Point("Satria Muda Pertamina",
                "10201830",
                "https://upload.wikimedia.org/wikipedia/en/thumb/5/58/SM_Pertamina.png/200px-SM_Pertamina.png"));

        listPoint.add(new Point("Pasific Caesar",
                "102018307",
                "https://cdn.scores24.ru/upload/team/origin/f2d/be4/2f82a5e7a5d5b740bb1a099b53b8fc5173.png"));

        listPoint.add(new Point("Aspac Jakarta",
                "102018301",
                "https://upload.wikimedia.org/wikipedia/en/thumb/a/ac/Aspac_logo.png/220px-Aspac_logo.png"));

        listPoint.add(new Point("Pelita Jaya",
                "102018301",
                "https://upload.wikimedia.org/wikipedia/en/0/03/Pelita_Jaya_BC_logo.png"));
    }
}
