package org.hicapacity.techhui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.res.AssetManager;

/**
 * @author Jason Axelson
 * 
 */
public class FileScheduleRetriever implements ScheduleRetriever {
  AssetManager mManager;

  public FileScheduleRetriever(AssetManager manager) {
    mManager = manager;
  }

  /** {@inheritDoc} */
  @Override
  public List<ScheduleElement> getElements() throws IOException {
    BufferedReader br = null;
    br = new BufferedReader(new InputStreamReader(mManager.open("data.txt")));
    System.out.println(br.readLine());
    ArrayList<ScheduleElement> scheduleList = new ArrayList<ScheduleElement>();
    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
      ScheduleElement scheduleElement = ScheduleElement.parseFromString(line);
      scheduleList.add(scheduleElement);
    }
    return scheduleList;
  }

}
