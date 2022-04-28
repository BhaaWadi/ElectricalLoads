package com.example.electricalloads.adapter;

import com.example.electricalloads.Pojo.ElectricConverter;
import com.example.electricalloads.Pojo.Reading;
import com.example.electricalloads.databinding.CustomRecItemDetalisBinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

;

public class ReadingAdapter extends RecyclerView.Adapter<ReadingAdapter.ReadingHolder> {
    private List<Reading> items;
    Context context;
    private OnItemClickListener listener;

    public OnItemClickListener getListener() {
        return listener;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ReadingAdapter(List<Reading> items, Context context) {
        this.items = items;
        this.context = context;
    }


    public void addItem(Reading reading){
        items.add(reading);
    }
    public List<Reading> getItems() {
        return items;
    }

    public void setItems(List<Reading> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ReadingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomRecItemDetalisBinding binding = CustomRecItemDetalisBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ReadingHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ReadingHolder holder, int position) {
        Reading item = items.get(position);

        holder.item = item;

        holder.bind(item);

//
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ReadingHolder extends RecyclerView.ViewHolder {
        CustomRecItemDetalisBinding binding;
        Reading item;

        public ReadingHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomRecItemDetalisBinding.bind(itemView);


//
        }


        public void bind(Reading item) {

         int Dir_skina=   item.getDir_skina();
          String direction="";
         if(Dir_skina==1) direction="شمال";
         if(Dir_skina==2) direction="جنوب";
         if(Dir_skina==3) direction="شرق";
         if(Dir_skina==4) direction="غرب";
        binding.textDirection.setText(direction);

        binding.textResidentialCapacity.setText(String.valueOf(item.getPower_skina()));
        binding.textR.setText(String.valueOf(item.getR()));
        binding.textS.setText(String.valueOf(item.getS()));
        binding.textT.setText(String.valueOf(item.getT()));
        binding.textN.setText(String.valueOf(item.getN()));
        binding.textRs.setText(String.valueOf(item.getRS()));
        binding.textRT.setText(String.valueOf(item.getRT()));
        binding.textSt.setText(String.valueOf(item.getST()));
        binding.textRN.setText(String.valueOf(item.getRN()));
        binding.textSN.setText(String.valueOf(item.getSN()));
        binding.textTN.setText(String.valueOf(item.getTN()));

        }


    }


    public interface OnItemClickListener {

        void onItemClick(Reading i);

    }
}
