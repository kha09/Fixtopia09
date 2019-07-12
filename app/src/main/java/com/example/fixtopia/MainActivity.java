package com.example.fixtopia;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listview;
    private CircleImageView cirlceImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        initToolbar();
    }

    private void setupUIViews(){
        toolbar = findViewById(R.id.ToolbarMain);
        listview = findViewById(R.id.lvMain);
        cirlceImage = findViewById(R.id.circleImageMain);
        cirlceImage.setImageResource(R.drawable.logo);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("FixTopia");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView(){
        String[] title = getResources().getStringArray(R.array.Main);

    }
    public class SimpleAdapter extends BaseAdapter{
        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView title;
        private String[] titlearray;
        private ImageView imageView;
        public SimpleAdapter(Context context, String[] title){
            mcontext = context;
            titlearray = title;
            layoutInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount(){return titlearray.length; }
        @Override
        public Object getItem(int position) {
            return titlearray[position];
        }
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.activity_main_single_item, null);
            }
            title = convertView.findViewById(R.id.tvMain);
            imageView = convertView.findViewById(R.id.ivMain);

            title.setText(titlearray[position]);

            if (titlearray[position].equalsIgnoreCase("Phone")) {
                imageView.setImageResource(R.drawable.iphonex);
            } else {
                imageView.setImageResource(R.drawable.logo);
            }
            return convertView;
        }

    }
}
