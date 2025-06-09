package com.example.hw2;

import android.content.Context;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> items;

    public ItemAdapter(@NonNull Context context, ArrayList<String> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        TextView txtItemInfo = convertView.findViewById(R.id.txtItemInfo);
        String item = items.get(position);
        txtItemInfo.setText(item);


        return convertView;
    }
}
