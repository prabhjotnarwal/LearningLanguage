package com.example.learninglanguage.admin;

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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.learninglanguage.R;
import com.example.learninglanguage.levelAnimal;
import com.example.learninglanguage.levelColor;
import com.example.learninglanguage.levelFruit;
import com.example.learninglanguage.nothingToDisplay;
import com.example.learninglanguage.viewLevels;
import com.google.gson.Gson;

import java.util.List;


public class categoryListAdapter extends RecyclerView.Adapter<categoryListAdapter.categoryViewHolder>{
    private Context context;
    RelativeLayout layout;
    private List<uploadCategory> categoryList;
    private List<String> idList;

    public categoryListAdapter(Context context, List<uploadCategory> categoryList, List<String> idList) {
        this.context = context;
        this.categoryList = categoryList;
        this.idList = idList;

    }


       @NonNull
       @Override
       public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(context).inflate(R.layout.layout1_category, parent, false);
           return new categoryViewHolder(view);
       }


       @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, final int position) {

        final uploadCategory category = categoryList.get(position);
        final String id = idList.get(position);
        holder.categoryName.setText(category.getCategoryName());

        holder.categoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String jsonString = gson.toJson(category);
                if(position==0){
                     Intent intent = new Intent(context, viewLevels.class);
                     context.startActivity(intent);}
                else if(position==1){
                    Intent intent = new Intent(context, levelColor.class);
                    //intent.putExtra("position",position);
                    context.startActivity(intent);}
               else if(position==2){
                    Intent intent = new Intent(context, levelFruit.class);
                    context.startActivity(intent);}
                else if(position==3){
                    Intent intent = new Intent(context, nothingToDisplay.class);
                    context.startActivity(intent);}
                else if(position==4){
                    Intent intent = new Intent(context, nothingToDisplay.class);
                    context.startActivity(intent);}
                else if(position==5){
                    Intent intent = new Intent(context, nothingToDisplay.class);
                    context.startActivity(intent);}

                else if(position==6){
                    Intent intent = new Intent(context, nothingToDisplay.class);
                    context.startActivity(intent);}
               else{
                    Intent intent = new Intent(context, nothingToDisplay.class);
                    context.startActivity(intent);}
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

       public class categoryViewHolder extends RecyclerView.ViewHolder {
           TextView categoryName;
           public categoryViewHolder(@NonNull View itemView) {
               super(itemView);
               context = itemView.getContext();
               categoryName = itemView.findViewById(R.id.catName);
               layout = itemView.findViewById(R.id.layout3);
               TextPaint paint = categoryName.getPaint();
               float width = paint.measureText("Alphabet, Color");

               Shader textShader = new LinearGradient(0, 0, width, categoryName.getTextSize(),
                       new int[]{
                               Color.parseColor("#E12807"),
                               Color.parseColor("#0450E6"),
                               Color.parseColor("#64B678"),
                               Color.parseColor("#0450E6"),
                               Color.parseColor("#DF04E6"),
                       }, null, Shader.TileMode.CLAMP);

               categoryName.getPaint().setShader(textShader);

           }


       }
}
