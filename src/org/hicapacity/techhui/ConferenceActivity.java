package org.hicapacity.techhui;

import java.io.IOException;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ConferenceActivity extends ListActivity {
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    System.out.println("creating conference activity");

    ScheduleRetriever scheduleRetriever = new FileScheduleRetriever(getAssets());
    List<ScheduleElement> elements = null;
    try {
      elements = scheduleRetriever.getElements();
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
    // "Blackberry",
    // "WebOS", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2" };
    // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
    // android.R.layout.simple_list_item_1, values);
    ArrayAdapter<ScheduleElement> adapter = new ArrayAdapter<ScheduleElement>(this,
        android.R.layout.simple_list_item_1, elements);
    this.setListAdapter(adapter);
  }

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    ScheduleElement item = (ScheduleElement) getListAdapter().getItem(position);
    Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
  }
}
