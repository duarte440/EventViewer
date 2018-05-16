package com.drr.eventview.drr.eventviewer.model;

import java.util.ArrayList;

public class EventProvider {

    // Singleton pattern

    private static EventProvider _instance;

    private EventProvider() {
        initializeData();
    }

    public static EventProvider getInstance() {
        if (_instance == null) {
            _instance = new EventProvider();
        }
        return _instance;
    }


    private Event[] eventData;



    private void initializeData() {
        eventData = new Event[]{
                new Event(1,"Sunset", "Lisboa, Campo Grande", "18/07/2074","50" , "http://triplov.com/jardins/campo_grande/images/lago.jpg"),

                new Event(2,"Feira do Livro de Lisboa", "Lisboa, Parque Eduardo VII", "19/07/2074","10","https://nit.pt/wp-content/uploads/2017/04/48285866-754x394.jpg"),

                new Event(3,"Rock Week", "Lisboa, Parque da Bela Vista", "20/07/2074","50","http://www.vamosaqui.pt/wp-content/uploads/2016/06/Parque-da-Bela-Vista.jpg"),

                new Event(4,"Rock Week", "Lisboa, Parque da Bela Vista", "20/07/2074","50","http://www.vamosaqui.pt/wp-content/uploads/2016/06/Parque-da-Bela-Vista.jpg"),

                new Event(5,"Rock Week", "Lisboa, Parque da Bela Vista", "20/07/2074","50","http://www.vamosaqui.pt/wp-content/uploads/2016/06/Parque-da-Bela-Vista.jpg"),

                new Event(6,"Rock Week", "Lisboa, Parque da Bela Vista", "20/07/2074","50","http://www.vamosaqui.pt/wp-content/uploads/2016/06/Parque-da-Bela-Vista.jpg"),

                new Event(7,"Sunset", "Lisboa, Campo Grande", "18/07/2074","50" , "http://triplov.com/jardins/campo_grande/images/lago.jpg"),
        };
    }

    public Event[] getEvents() {
        return eventData;
    }


    public Event getEvent(int eventId) {
        for (int i=0; i < eventData.length; i++) {
            if (eventData[i].getId() == eventId) {
                return eventData[i];
            }
        }
        return null;
    }

}
