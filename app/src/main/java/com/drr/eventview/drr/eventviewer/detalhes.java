package com.drr.eventview.drr.eventviewer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.drr.eventview.drr.eventviewer.model.EventProvider;
import com.drr.eventview.drr.eventviewer.model.Event;


public class detalhes extends AppCompatActivity{



    public static final String event_ID = "com.drr.eventview.drr.eventviewer.event_ID_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        // Get parameter from previous screen
        int eventId = this.getIntent().getIntExtra(detalhes.event_ID, -1);
        if (eventId > -1) {
            Event event = EventProvider.getInstance().getEvent(eventId);
            TextView mTextViewTitle = (TextView) this.findViewById(R.id.event_detail_nome);
            mTextViewTitle.setText(event.getNome());
            TextView mTextViewTitle1 = (TextView) this.findViewById(R.id.event_detail_Localizacao);
            mTextViewTitle1.setText(event.getLocalizacao());

            TextView mTextViewTitle2 = (TextView) this.findViewById(R.id.event_detail_Preco);
            mTextViewTitle2.setText(event.getPreco());

            TextView mTextViewTitle3 = (TextView) this.findViewById(R.id.event_detail_Data);
            mTextViewTitle3.setText(event.getData());
        }


        }


    }


