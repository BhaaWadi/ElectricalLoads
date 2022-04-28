package com.example.electricalloads.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.electricalloads.Pojo.ElectricConverter;
import com.example.electricalloads.databinding.CustomItemHomeActivityBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

;

public class ElectricConverterAdapter extends RecyclerView.Adapter<ElectricConverterAdapter.ElectricConverterHolder> {
    private List<ElectricConverter>items;
    Context context;
    private OnItemClickListener listener;

    public OnItemClickListener getListener() {
        return listener;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ElectricConverterAdapter(List<ElectricConverter>items, Context context) {
        this.items = items;
        this.context = context;
    }

    public List<ElectricConverter>

    getItems() {
        return items;
    }

    public void setItems(List<ElectricConverter>items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ElectricConverterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomItemHomeActivityBinding binding = CustomItemHomeActivityBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ElectricConverterHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ElectricConverterHolder holder, int position) {
        ElectricConverter item = items.get(position);
        holder.item = item;

        holder.bind(item);

//
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ElectricConverterHolder extends RecyclerView.ViewHolder {
        CustomItemHomeActivityBinding binding;
        ElectricConverter  item;

        public ElectricConverterHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomItemHomeActivityBinding.bind(itemView);

            binding.btnDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });


//
        }


        public void bind(ElectricConverter item) {

            binding.textNumber.setText(String.valueOf(item.getId_material()));
            binding.textName.setText(item.getConverterName());
            binding.address.setText(item.getGovernorate());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = dateFormat.format(item.getLastReadDate());
            binding.textData.setText(strDate);





        }


    }


    public interface OnItemClickListener {

        void onItemClick(ElectricConverter i);

    }
}
