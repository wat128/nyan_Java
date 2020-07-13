package com.wat128.nyan_java;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    private LayoutInflater inflater;
    private int itemLayoutId;
    private List<String> titles;
    private List<Integer> ids;

    ListViewAdapter(Context context, int itemLayoutId,
                    List<String> itemNames, List<Integer> itemImages) {
        super();
        this.inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemLayoutId = itemLayoutId;
        this.titles = itemNames;
        this.ids = itemImages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // 最初だけ View を inflate して、それを再利用する
        if (convertView == null) {
            // activity_main.xml に list.xml を inflate して convertView とする
            convertView = inflater.inflate(itemLayoutId, parent, false);
            // ViewHolder を生成
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView);
            holder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);

            if(position == 0) {
                convertView.setBackgroundColor(Color.rgb(255, 127, 255));
            }
            else if(position == 1) {
                convertView.setBackgroundColor(Color.rgb(255, 220, 127));
            }
            else if (position == 2) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 300);

                convertView.setLayoutParams(params);

                convertView.setBackgroundColor(Color.rgb(127, 127, 255));

                holder.textView.setTextColor(Color.rgb(0, 0, 255));
                holder.textView.setTextSize(20.0f);
                holder.textView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);

                params = new LinearLayout.LayoutParams(300, 300);
                params.setMargins(50, 0, 0, 0);

                holder.imageView.setLayoutParams(params);

            }
            else if(position == 3) {
                convertView.setBackgroundColor(Color.rgb(127,255,127));
            }
            else {
                convertView.setBackgroundColor(Color.rgb(255,255,127));
            }
        }
        // holder を使って再利用
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(ids.get(position));
        holder.textView.setText(titles.get(position));

        return convertView;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
