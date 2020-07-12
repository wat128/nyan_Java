package com.wat128.nyan_java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends ListActivity {

    class CellData{
        String imageComment;
        int imageDrawableId;

        CellData(String imageComment, int imageDrawableId) {
            this.imageComment = imageComment;
            this.imageDrawableId = imageDrawableId;
        }
    }

    private Integer[] imageDrawables = {
            android.R.drawable.ic_menu_call,
            android.R.drawable.ic_menu_close_clear_cancel,
            android.R.drawable.ic_menu_compass,
            android.R.drawable.ic_menu_delete,
            android.R.drawable.ic_menu_directions,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_edit,
            android.R.drawable.ic_menu_help
    };

    private String[] imageComments = {
            "call", "cancel", "compass", "crop", "delete",
            "directions", "gallery", "edit", "help"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("debug", "MainActivity.onCreate");

        List<CellData> list = new ArrayList<>();

        for(int i = 0; i < imageDrawables.length; ++i) {
            CellData data = new CellData(imageComments[i], imageDrawables[i]);
            list.add(data);
        }

        setListAdapter(new ListViewAdapter(this, R.layout.list, list));

    }

    class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    class ListViewAdapter extends ArrayAdapter<CellData> {
        private LayoutInflater inflater;
        private int itemLayout;
        CellData data;

        ListViewAdapter(Context context, int itemLayout, List<CellData> list) {
            super(context, 0, list);
            this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.itemLayout = itemLayout;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null) {
                convertView = inflater.inflate(itemLayout, parent, false);
                holder = new ViewHolder();
                holder.textView = convertView.findViewById(R.id.textView);
                holder.imageView = convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }

            data = getItem(position);
            if(data != null) {
                holder.textView.setText(data.imageComment);
                holder.imageView.setImageResource(data.imageDrawableId);
            }
            return convertView;
        }
    }
}

