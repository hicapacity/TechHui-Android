package org.hicapacity.techhui;

import java.io.IOException;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ConferenceActivity extends ListActivity {
  private Button mT1Button;
  private Button mT2Button;

  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.schedule_list);

    List<ScheduleElement> elements = null;
    try {
      mScheduleRetriever = new FileScheduleRetriever(getAssets());
      elements = mScheduleRetriever.getTrack1Elements();
      // elements.addAll(scheduleRetriever.getTrack2Elements());
    }
    catch (IOException e) {
      // TODO: Maybe show user error in this case.
      e.printStackTrace();
    }

    System.out.println("create adapter");
    MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, elements);
    System.out.println("adapter is " + adapter);
    this.setListAdapter(adapter);

    mT1Button = (Button) this.findViewById(R.id.t1Button);
    mT1Button.setOnClickListener(mTrack1Listener);

    mT2Button = (Button) this.findViewById(R.id.t2Button);
    mT2Button.setOnClickListener(mTrack2Listener);
  }

  private OnClickListener mTrack1Listener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      Toast.makeText(ConferenceActivity.this, "Track Two is in Art 101", Toast.LENGTH_LONG)
          .show();
      List<ScheduleElement> track1Elements = null;
      try {
        track1Elements = mScheduleRetriever.getTrack1Elements();
      }
      catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(ConferenceActivity.this,
          track1Elements);
      ConferenceActivity.this.setListAdapter(adapter);
    }
  };

  private OnClickListener mTrack2Listener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      Toast.makeText(ConferenceActivity.this, "Track One is in the Art Auditorium",
          Toast.LENGTH_LONG).show();
      List<ScheduleElement> track2Elements = null;
      try {
        track2Elements = mScheduleRetriever.getTrack2Elements();
      }
      catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(ConferenceActivity.this,
          track2Elements);
      ConferenceActivity.this.setListAdapter(adapter);
    }
  };

  private ScheduleRetriever mScheduleRetriever;

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    ScheduleElement item = (ScheduleElement) getListAdapter().getItem(position);
    String description = item.getFullDescription() + "selected";
    Toast.makeText(this, description, Toast.LENGTH_LONG).show();
  }
}
