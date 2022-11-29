package com.example.curd_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PresentAdapter extends BaseAdapter {
    private Context context ;
    private int layout ;
    private List<Present> presentList;

    public PresentAdapter(Context context, int layout, List<Present> presentList) {
        this.context = context;
        this.layout = layout;
        this.presentList = presentList;
    }

    @Override
    public int getCount() {
        return presentList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout , null);

        //get component in view
        TextView title = (TextView) view.findViewById(R.id.titleTodo);
        TextView description = (TextView) view.findViewById(R.id.descriptionTodo);

        //gan gia tri

        Present present = presentList.get(i);
        title.setText(present.getTitle());
        description.setText(present.getDescription());
        return view;
    }
}
