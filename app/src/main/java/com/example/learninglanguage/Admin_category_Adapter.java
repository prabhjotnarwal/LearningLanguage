package com.example.learninglanguage;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.learninglanguage.admin.UpdateActivity;
import com.example.learninglanguage.admin.UpdateCategory;
import com.example.learninglanguage.admin.categoryListAdapter;
import com.example.learninglanguage.admin.uploadCategory;
import com.google.gson.Gson;

import java.util.List;

public class Admin_category_Adapter  extends RecyclerView.Adapter<Admin_category_Adapter.categoryViewHolder>{
    private Context context;
    RelativeLayout layout;
    private List<uploadCategory> categoryList;
    private List<String> idList;

    public Admin_category_Adapter(Context context, List<uploadCategory> categoryList, List<String> idList) {
        this.context = context;
        this.categoryList = categoryList;
        this.idList = idList;

    }


    @NonNull
    @Override
    public Admin_category_Adapter.categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_admin_category__adapter, parent, false);
        return new Admin_category_Adapter.categoryViewHolder(view);
    }


    public void onBindViewHolder(@NonNull Admin_category_Adapter.categoryViewHolder holder, final int position) {

        final uploadCategory category = categoryList.get(position);
        final String id = idList.get(position);
        holder.categoryName.setText(category.getCategoryName());

        holder.categoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String jsonString = gson.toJson(category);
                Intent intent = new Intent(context, UpdateCategory.class);
                intent.putExtra("category", jsonString);
                intent.putExtra("key", id);
                intent.putExtra("categoryName",category.getCategoryName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        RelativeLayout layout;
        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            categoryName = itemView.findViewById(R.id.catName1);
            layout = itemView.findViewById(R.id.layout4);
        }


    }
}
