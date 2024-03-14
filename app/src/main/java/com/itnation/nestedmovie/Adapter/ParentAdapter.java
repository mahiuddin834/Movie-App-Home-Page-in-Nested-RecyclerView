package com.itnation.nestedmovie.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.itnation.nestedmovie.Model.ParentItem;
import com.itnation.nestedmovie.R;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {

    private List<ParentItem> parentItemList;

    public void setParentItemList(List<ParentItem> parentItemList){
        this.parentItemList = parentItemList;
    }
    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item , parent , false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {

        ParentItem parentItem = parentItemList.get(position);
        holder.parentName.setText(parentItem.getParentName());



        holder.childRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        ChildAdapter childAdapter = new ChildAdapter();
        childAdapter.setChildItemList(parentItem.getChildItemList());
        holder.childRecyclerView.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (parentItemList != null){
            return parentItemList.size();
        }else{
            return 0;
        }

    }

    public class ParentViewHolder extends RecyclerView.ViewHolder{
        TextView parentName;

        RecyclerView childRecyclerView;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            parentName = itemView.findViewById(R.id.parent_Name);
            childRecyclerView = itemView.findViewById(R.id.child_recyclyer);
        }
    }
}
