package com.example.commuterhub;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


//NON USATA AL MOMENTO
public class ListItemViewModel extends AndroidViewModel {

    private LiveData<List<CardItem>> item_list;

    public ListItemViewModel(@NonNull Application application) {
        super(application);
        //CardItemRepository repository = new CardItemRepository(application);
        //item_list = repository.getItems();
    }

    public LiveData<List<CardItem>> getItems() {
        return item_list;
    }
}