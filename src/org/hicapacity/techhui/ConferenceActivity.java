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
      // TODO: Maybe show user error in this case.
      e.printStackTrace();
    }

    ArrayAdapter<ScheduleElement> adapter = new ArrayAdapter<ScheduleElement>(this,
        android.R.layout.simple_list_item_1, elements);
    this.setListAdapter(adapter);
  }

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    ScheduleElement item = (ScheduleElement) getListAdapter().getItem(position);
    String description = item.getFullDescription() + "selected";
    Toast.makeText(this, description, Toast.LENGTH_LONG).show();
  }
}
