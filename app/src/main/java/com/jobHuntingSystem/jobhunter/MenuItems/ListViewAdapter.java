package com.jobHuntingSystem.jobhunter.MenuItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jobHuntingSystem.jobhunter.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    public List<attributeNames> attributeNamesList = null;
    public ArrayList<attributeNames> arraylist;

    public ListViewAdapter(Context context, List<attributeNames> animalNamesList) {
        mContext = context;
        this.attributeNamesList = animalNamesList;
        inflater = LayoutInflater.from(mContext);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return attributeNamesList.size();
    }

    @Override
    public attributeNames getItem(int position) {
        return attributeNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(attributeNamesList.get(position).getEmail());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        attributeNamesList.clear();
        if (charText.length() == 0) {
            attributeNamesList.addAll((Collection<? extends attributeNames>) arraylist);
        } else {
            for (attributeNames wp : arraylist) {
                if (wp.getEmail().toLowerCase(Locale.getDefault()).contains(charText)) {
                    attributeNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}