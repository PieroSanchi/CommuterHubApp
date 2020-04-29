package com.example.commuterhub;

/**
 * Class which represents every card item with its information (title, place, time)
 */
class CardItem {
    private int id;
    private String title;
    private String time_place;

    CardItem(String title, String time_place) {
        this.title = title;
        this.time_place = time_place;
    }

    String getTitle() {
        return title;
    }

    String getTime_Place() {
        return time_place;
    }

    int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
