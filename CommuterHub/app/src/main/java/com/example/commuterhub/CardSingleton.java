package com.example.commuterhub;

import java.util.ArrayList;
import java.util.List;

public class CardSingleton {

    private List<CardItem> cardItemlist = new ArrayList<>();

    private static final CardSingleton ourIstance = new CardSingleton();

    static CardSingleton getInstance() {
        return ourIstance;
    }

    private CardSingleton() {
    }

    void addCardItem(CardItem item) {
        //imposto l'id come numero progressivo
        item.setId(cardItemlist.size());
        //aggiungo la nuova card alla lista
        cardItemlist.add(0, item);
    }

    List<CardItem> getCardItemList() {
        return cardItemlist;
    }

    CardItem getCardItem(int position) {
        return cardItemlist.get(position);
    }

    void clearAll(){
        cardItemlist.clear();
    }

}
