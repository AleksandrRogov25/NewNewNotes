package com.example.newnotes;


import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class CardSoursImpl implements CardSours {
    private List<CardData> dataSource;
    private Resources resources;


    public CardSoursImpl(Resources resources) {
        this.resources = resources;
        dataSource = new ArrayList<>(5);
    }
    public CardSoursImpl init(){
        String[] notes = resources.getStringArray(R.array.notes);
        String[] description = resources.getStringArray(R.array.notes_detail);
        String[] date = resources.getStringArray(R.array.date);
        for (int i = 0; i<5; i++){
            dataSource.add(new CardData(notes[i], description[i], date[i]));
        }

        return this;
    }


    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }

    @Override
    public int size() {
        return dataSource.size();
    }
}
