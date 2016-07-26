package com.example.turbo.expandablelistviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.turbo.expandablelistviewdemo.Adapters.MyExpandableListViewAdapter;
import com.example.turbo.expandablelistviewdemo.ItemBeans.ChildItemBean;
import com.example.turbo.expandablelistviewdemo.ItemBeans.GroupItemBean;
import com.example.turbo.expandablelistviewdemo.Views.AnimatedExpandableListView;
import com.example.turbo.expandablelistviewdemo.WebRequests.MenuRequest;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private AnimatedExpandableListView expandableListView;
    private MyExpandableListViewAdapter expandableListAdapter;
    private LinkedList<GroupItemBean> groupItems;
    private LinkedList<LinkedList<ChildItemBean>> childItems;
    private MenuRequest menuRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groupItems = new LinkedList<GroupItemBean>();
        for(int i = 1; i < 7; i++)
        {
            groupItems.add(new GroupItemBean(R.mipmap.ic_launcher, "Menu " + i));
        }

        childItems = new LinkedList<LinkedList<ChildItemBean>>();

        for(int i = 1; i < 7; i++)
        {
            LinkedList<ChildItemBean> groupChildItem = new LinkedList<ChildItemBean>();
            for(int j = 1; j < 5; j++)
            {
                groupChildItem.add(new ChildItemBean(R.mipmap.ic_launcher, "Menu " + i + "," + j));
            }
            childItems.add(groupChildItem);
        }

        expandableListView = (AnimatedExpandableListView) findViewById(R.id.expandedListViewId);
        expandableListAdapter = new MyExpandableListViewAdapter(MainActivity.this, groupItems, childItems);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(final ExpandableListView expandableListView, View view, int groupItemPostion, long l) {
                if(expandableListView.isGroupExpanded(groupItemPostion))
                {
                    ((AnimatedExpandableListView)expandableListView).collapseGroupWithAnimation(groupItemPostion);
                }
                else
                {
                    ((AnimatedExpandableListView)expandableListView).expandGroupWithAnimation(groupItemPostion);
                }

                menuRequest = new MenuRequest(MainActivity.this, "https://www.baidu.com");
                menuRequest.sendMenuRequest();
                return true;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(MainActivity.this, "childitem position " + i1, Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }

    public void RefreshActivity(String str, int Image)
    {
        expandableListAdapter.RefreshAdapter(str);


    }
}
