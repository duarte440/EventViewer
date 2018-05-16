package com.drr.eventview.drr.eventviewer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.InputStream;

import com.drr.eventview.drr.eventviewer.model.Event;

public class EventListAdapter extends RecyclerView.Adapter<com.drr.eventview.drr.eventviewer.EventListAdapter.ViewHolder> {

    private Event[] mDataSet;

    // Provide a reference to the views for each data item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTextViewTitle;
        public final TextView mTextViewLocalizacao;
        public final ImageView mImageViewCover;

        public ViewHolder(View view) {
            super(view);

            mView = view;
            mTextViewTitle = (TextView) view.findViewById(R.id.event_list_title);
            mTextViewLocalizacao = (TextView) view.findViewById(R.id.event_list_localizacao);
            mImageViewCover = (ImageView) view.findViewById(R.id.event_list_cover);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public com.drr.eventview.drr.eventviewer.EventListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // get element from your dataset at this position
        // replace the contents of the view with that element
        holder.mTextViewTitle.setText(mDataSet[position].getNome());
        holder.mTextViewLocalizacao.setText(mDataSet[position].getLocalizacao());

        // Starts AsyncTask to download cover
        new DownloadImageTask((ImageView)holder.mImageViewCover).execute(mDataSet[position].getThumb());

        // Set click listener
        holder.mView.setOnClickListener( new eventos.RecyclerViewItemClickListener( mDataSet[position].getId() ) );


    }



    // Download image from URL asynchronously and loads to ImageView
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap bitmapImage = null;
            try {
                InputStream in = new java.net.URL(url).openStream();
                bitmapImage = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bitmapImage;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }


    // Return the size of your data-set (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }


    public EventListAdapter(Event[] myDataset) {
        this.mDataSet = myDataset;
    }


    // Enable the update and notification of data-set
    public void updateData(Event[] newDataSet) {
        Log.d(this.getClass().toString(), "Updating Adapter data with " + newDataSet.length + " items");
        this.mDataSet = newDataSet;
        notifyDataSetChanged();
    }
}