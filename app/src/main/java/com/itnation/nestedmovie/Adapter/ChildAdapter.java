package com.itnation.nestedmovie.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Placeholder;
import androidx.recyclerview.widget.RecyclerView;


import com.itnation.nestedmovie.MainActivity2;
import com.itnation.nestedmovie.Model.ChildItem;
import com.itnation.nestedmovie.R;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    private List<ChildItem> childItemList;
    Context context;
    public void setChildItemList(List<ChildItem> childItemList){
        this.childItemList = childItemList;

        this.childItemList.removeAll(Collections.singleton(null));
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item , parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {

        ChildItem childItem = childItemList.get(position);
        holder.childName.setText(childItem.getChildName());
        holder.childDes.setText(childItem.getChildDes());
        String thumbId= childItem.getChildImage();


        String final_id = "https://img.youtube.com/vi/" + thumbId + "/hqdefault.jpg";
        Picasso.get().load(final_id).placeholder(R.drawable.mov_img).into(holder.childImageView);



        holder.childImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });



    }

    @Override
    public int getItemCount() {
        if (childItemList != null){
            return childItemList.size();
        }else{
            return  0;
        }
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder{
        TextView childName, childDes;
        ImageView childImageView;
        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);

            childName = itemView.findViewById(R.id.movie_name);
            childImageView = itemView.findViewById(R.id.child_image);
            childDes = itemView.findViewById(R.id.movie_des);
        }
    }
}
