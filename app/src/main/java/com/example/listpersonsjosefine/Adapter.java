package com.example.listpersonsjosefine;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;



public class Adapter extends ArrayAdapter<Personmodel> {

    //the hero list that will be displayed
    private List<Personmodel> personlist;

    //the context object
    private Context mCtx;

    //here we are getting the herolist and context
    //so while creating the object of this adapter class we need to give herolist and context
    public Adapter(List<Personmodel> personlist, Context mCtx) {
        super(mCtx, R.layout.itemlist, personlist);
        this.personlist = personlist;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.itemlist, null, true);

        //getting text views
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewEmail = listViewItem.findViewById(R.id.textViewEmail);
        TextView textViewNote = listViewItem.findViewById(R.id.textViewNote);

        //Getting the hero for the specified position
        Personmodel person = personlist.get(position);

        //setting hero values to textviews
        textViewName.setText(person.getName());
        textViewEmail.setText(person.getEmail());
        textViewNote.setText(person.getNote());

        //returning the listitem
        return listViewItem;
    }
}