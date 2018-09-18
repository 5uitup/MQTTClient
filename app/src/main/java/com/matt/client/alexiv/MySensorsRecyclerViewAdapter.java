package com.matt.client.alexiv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.matt.client.alexiv.SensorsFragment.OnListFragmentInteractionListener;
import com.matt.client.alexiv.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MySensorsRecyclerViewAdapter extends RecyclerView.Adapter<MySensorsRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    //private String typeSensors;

    public MySensorsRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, String typeSensors) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.fragment_sensors, parent, false);
        View view;
        switch (typeSensors){
            case "switch":
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_sensors, parent, false);
                return new ViewHolder(view);
            case "temperature":
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout., parent, false);
            default:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_sensors, parent, false);
                return new ViewHolder(view);
                break;

        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
