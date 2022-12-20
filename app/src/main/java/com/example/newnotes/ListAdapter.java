package com.example.newnotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    CardSours dataSource;
    private OnItemClickListener itemClickListener;
    public ListAdapter(CardSours dataSource) {

        this.dataSource = dataSource;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.itemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.setDate(dataSource.getCardData(position));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView notes;
        private TextView description;
        private TextView date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notes = itemView.findViewById(R.id.notes);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
            notes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(itemClickListener != null)
                        itemClickListener.onItemClick(view, position);
                }
            });
        }

        public  void setDate(CardData cardData){
            notes.setText(cardData.getName());
            description.setText(cardData.getDescription());
            date.setText(cardData.getDate());
        }
    }
}
