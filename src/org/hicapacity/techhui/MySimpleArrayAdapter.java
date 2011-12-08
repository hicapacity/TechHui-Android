package org.hicapacity.techhui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<ScheduleElement> {
  private final Context context;
  private final List<ScheduleElement> values;

  public MySimpleArrayAdapter(Context context, List<ScheduleElement> values) {
    super(context, R.layout.schedule_item, values);
    this.context = context;
    this.values = new ArrayList<ScheduleElement>(values);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.schedule_item, parent, false);
    TextView textView = (TextView) rowView.findViewById(R.id.schedule_description);
//    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
    TextView timeView = (TextView) rowView.findViewById(R.id.schedule_time);
    
    ScheduleElement scheduleElement = values.get(position);
    
    textView.setText(scheduleElement.getTitle());
    timeView.setText(scheduleElement.getTime());

    return rowView;
  }
}
