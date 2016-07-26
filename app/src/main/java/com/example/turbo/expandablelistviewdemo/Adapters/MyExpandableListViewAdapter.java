package com.example.turbo.expandablelistviewdemo.Adapters;

/**
 * Created by turbo on 2016/7/25.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.turbo.expandablelistviewdemo.ItemBeans.ChildItemBean;
import com.example.turbo.expandablelistviewdemo.ItemBeans.GroupItemBean;
import com.example.turbo.expandablelistviewdemo.R;
import com.example.turbo.expandablelistviewdemo.Views.AnimatedExpandableListView.AnimatedExpandableListAdapter;

import java.util.LinkedList;

public class MyExpandableListViewAdapter extends AnimatedExpandableListAdapter {

    private Context context;
    private LinkedList<GroupItemBean> groupItems;
    private LinkedList<LinkedList<ChildItemBean>> childItems;

    public MyExpandableListViewAdapter(Context context, LinkedList<GroupItemBean> groupItems, LinkedList<LinkedList<ChildItemBean>> childItems) {
        this.context = context;
        this.groupItems = new LinkedList<>(groupItems);
        this.childItems = new LinkedList<>(childItems);
    }

    @Override
    public View getGroupView(int groupItemPosition, boolean b, View convertView, ViewGroup viewGroup) {
        GroupItemHolder groupItemHolder = null;
        TextView tempTextView = null;
        ImageView tempImageView = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.groupitem_layout, null);
            groupItemHolder = new GroupItemHolder();
            convertView.setTag(groupItemHolder);
        } else {
            groupItemHolder = (GroupItemHolder) convertView.getTag();
        }

        tempTextView = (TextView) convertView.findViewById(R.id.groupItemTVId);
        tempImageView = (ImageView) convertView.findViewById(R.id.groupItemIMId);
        groupItemHolder.setTextView(tempTextView);
        groupItemHolder.setImageView(tempImageView);
        tempTextView.setText(groupItems.get(groupItemPosition).getgroupItemName().toString());
        tempImageView.setImageResource(groupItems.get(groupItemPosition).getgroupImage());
        return convertView;
    }

    @Override
    public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildItemHolder childItemHolder = null;
        ProgressBar tempProgressBar = null;
        TextView tempTextView = null;
        ImageView tempImageView = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.childitem_layout, null);
            childItemHolder = new ChildItemHolder();
            convertView.setTag(childItemHolder);
        } else {
            childItemHolder = (ChildItemHolder) convertView.getTag();
        }

        tempProgressBar = (ProgressBar) convertView.findViewById(R.id.childItemProgressbarId);
        tempTextView = (TextView) convertView.findViewById(R.id.childItemTVId);
        tempImageView = (ImageView) convertView.findViewById(R.id.childItemIMId);
        childItemHolder.setProgressBar(tempProgressBar);
        childItemHolder.setTextView(tempTextView);
        childItemHolder.setImageView(tempImageView);
        tempTextView.setText(childItems.get(groupPosition).get(childPosition).getChildItemName().toString());
        tempImageView.setImageResource(childItems.get(groupPosition).get(childPosition).getChildImage());
        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return childItems.get(groupPosition).size();
    }

    @Override
    public int getGroupCount() {
        return groupItems.size();
    }

    @Override
    public Object getGroup(int i) {
        return groupItems.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childItems.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public void RefreshAdapter(String str)
    {
        LinkedList<ChildItemBean> itemBeen = new LinkedList<ChildItemBean>();
        itemBeen.add(new ChildItemBean(R.mipmap.ic_launcher, str));
        childItems.set(0, itemBeen);
        notifyDataSetChanged();
    }
}

class GroupItemHolder
{
    private TextView textView;
    private ImageView imageView;

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}

class ChildItemHolder
{
    private ProgressBar progressBar;
    private TextView textView;
    private ImageView imageView;

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    public void setProgressBar(ProgressBar progressBar)
    {
        this.progressBar = progressBar;
    }
}
