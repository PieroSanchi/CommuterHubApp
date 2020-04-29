package com.example.commuterhub;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Adapter linked to the RecyclerView of the homePage, that extends a custom ViewHolder and
 * implements Filterable for the SearchView
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private static final String LOG = "CardAdapter-LAB";
    //list that can be filtered
    private List<CardItem> cardItemList;
    //list that contains ALL the element added by the user
    private List<CardItem> cardItemListFull;

    //listener attached to the onclick event for the item in yhe RecyclerView
    private OnItemListener listener;

    CardAdapter(List<CardItem> cardItemList, OnItemListener listener) {
        this.cardItemList = new ArrayList<>(cardItemList);
        this.cardItemListFull = new ArrayList<>(cardItemList);

        this.listener = listener;
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
     *
     * @param parent   ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new CardViewHolder(layoutView, listener);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the RecyclerView.ViewHolder.itemView to reflect
     * the item at the given position.
     *
     * @param holder   ViewHolder which should be updated to represent the contents of the item at
     *                 the given position in the data set.
     * @param position position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem currentCardItem = cardItemList.get(position);

        holder.titleTextView.setText(currentCardItem.getTitle());
        holder.timePlaceTextView.setText(currentCardItem.getTime_Place() /*!= null ? currentCardItem.getTime() : currentCardItem.getPlace()*/);
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    void updateList() {
        Log.d(LOG, "updateList()");
        cardItemList.clear();
        cardItemList.addAll(CardSingleton.getInstance().getCardItemList());
        notifyDataSetChanged();
    }

    /**
     * A ViewHolder describes an item view and the metadata about its place within the RecyclerView.
     * Every item in the list has a listener for the onclick event
     */
    static class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTextView;
        TextView timePlaceTextView;

        OnItemListener itemListener;

        CardViewHolder(@NonNull View itemView, OnItemListener lister) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            timePlaceTextView = itemView.findViewById(R.id.timePlaceTextView);

            itemListener = lister;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemListener.onItemClick(getAdapterPosition());
        }
    }

    /**
     * Interface to manage the listener for the click on an element of the RecyclerView
     */
    public interface OnItemListener {
        void onItemClick(int position);
    }

    /**
     * Method called when a new item is added
     * @param newData the new list of items
     */
    public void setData(List<CardItem> newData) {
        this.cardItemList.clear();
        this.cardItemList.addAll(newData);
        this.cardItemListFull.clear();
        this.cardItemListFull.addAll(newData);
        notifyDataSetChanged();
    }

}
