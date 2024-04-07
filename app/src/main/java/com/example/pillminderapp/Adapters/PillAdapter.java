package com.example.pillminderapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pillminderapp.Interfaces.RemoveCallback;
import com.example.pillminderapp.Model.Cabinet;
import com.example.pillminderapp.Model.Pill;
import com.example.pillminderapp.R;
import com.example.pillminderapp.Utilities.ImageLoader;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class PillAdapter extends RecyclerView.Adapter<PillAdapter.PillViewHolder> {


    private Context context;
    private ArrayList<Pill> pills;


    private RemoveCallback removeCallback;

    public void setRemoveCallback(RemoveCallback removeCallback) {
        this.removeCallback = removeCallback;
    }

    public PillAdapter(Context context, Cabinet pills) {
        this.context = context;
        this.pills = pills.getPills();
    }

    private Pill getItem(int position) {
        return pills.get(position);
    }


    @NonNull
    @Override
    public PillAdapter.PillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.pill_item, parent, false);
        return new PillViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PillAdapter.PillViewHolder holder, int position) {
        Pill pill = getItem(position);
        ImageLoader.getInstance().load(pill.getImgURL(),holder.pill_IMG_poster);
        holder.pill_LBL_name.setText(pill.getName());
        holder.pill_LBL_isMeal.setText(pill.getMeal());
        holder.pill_LBL_quantity.setText("" + pill.getQuantity());
        holder.pill_LBL_time.setText(String.valueOf(pill.getTime()));

    }

    @Override
    public int getItemCount() {
        return pills == null ? 0 : pills.size();
    }


    public class PillViewHolder extends RecyclerView.ViewHolder {

        private MaterialTextView pill_LBL_name;
        private MaterialTextView pill_LBL_time;
        private MaterialTextView pill_LBL_desc;
        private MaterialTextView pill_LBL_isMeal;
        private MaterialTextView pill_LBL_quantity;
        private MaterialCardView pill_CARD_data;
        private ShapeableImageView pill_IMG_poster;

        private MaterialButton pill_BTN_remove;

        public PillViewHolder(@NonNull View itemView) {

            super(itemView);
            pill_LBL_name = itemView.findViewById(R.id.pill_LBL_name);
            pill_LBL_time = itemView.findViewById(R.id.pill_LBL_time);
            pill_LBL_desc = itemView.findViewById(R.id.pill_LBL_desc);
            pill_LBL_isMeal = itemView.findViewById(R.id.pill_LBL_isMeal);
            pill_LBL_quantity = itemView.findViewById(R.id.pill_LBL_quantity);
            pill_CARD_data = itemView.findViewById(R.id.pill_CARD_data);
            pill_IMG_poster = itemView.findViewById(R.id.pill_IMG_poster);
            pill_BTN_remove = itemView.findViewById(R.id.pill_BTN_remove);
            pill_BTN_remove.setOnClickListener(v->{
                    removeCallback.removePill(pills,getAdapterPosition());
            });
        }
    }
}
