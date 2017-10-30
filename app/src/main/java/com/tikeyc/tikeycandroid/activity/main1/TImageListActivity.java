package com.tikeyc.tikeycandroid.activity.main1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tikeyc.tikeycandroid.R;
import com.tikeyc.tikeycandroid.base.TBaseActivity;
import com.tikeyc.tikeycandroid.libs.CircleImageView;
import com.tikeyc.tnineplacegridviewlibrary.TNinePlaceGridView.TNinePlaceGridView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TImageListActivity extends TBaseActivity {

    @ViewInject(R.id.listView)
    private ListView listView;
    @ViewInject(R.id.navigationbar)
    private LinearLayout navigationbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_timage_list);
        View view = View.inflate(this,R.layout.activity_timage_list,null);
        setContentView(view);

        x.view().inject(this,view);
        init();
    }

    private void init() {

        List<List<Object>> imageNames2D = new ArrayList<List<Object>>();
        for (int i = 0; i < 30; i++) {
            ArrayList<Object> imageNames = new ArrayList<Object>();
            Random random = new Random();
            for (int j = 0; j <= random.nextInt(8); j++) {
                if (j%2 == 0) {
                    imageNames.add(R.mipmap.beauty);
                } else {
                    imageNames.add(R.mipmap.glenceluanch);
                }
            }
            imageNames2D.add(imageNames);
        }
        ListViewAdapter listViewAdapter = new ListViewAdapter(this);
        listViewAdapter.imageNames2D = imageNames2D;
        listView.setAdapter(listViewAdapter);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    private class ListViewAdapter extends BaseAdapter {

        private Context context;
        public List<List<Object>> imageNames2D;

        public ListViewAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            if (imageNames2D != null) return imageNames2D.size();
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        private class ViewHelper {
            CircleImageView imageViewIcon;
            TextView textViewNickName;
            TNinePlaceGridView ninePlaceGridView;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            ViewHelper viewHelper;
            if (view == null) {
                view = View.inflate(context,R.layout.timage_listactivity_listview_item,null);
                viewHelper = new ViewHelper();
                viewHelper.imageViewIcon = (CircleImageView) view.findViewById(R.id.imageViewIcon);
                viewHelper.textViewNickName = (TextView) view.findViewById(R.id.textViewNickName);
                viewHelper.ninePlaceGridView = (TNinePlaceGridView) view.findViewById(R.id.ninePlaceGridView);

                view.setTag(viewHelper);
            } else  {
                viewHelper = (ViewHelper) view.getTag();
            }
            List<Object> imageNames = this.imageNames2D.get(i);
            viewHelper.ninePlaceGridView.setImageNames(imageNames);

            return view;
        }
    }




}
