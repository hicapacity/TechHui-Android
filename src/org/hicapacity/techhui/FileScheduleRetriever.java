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
  public List<ScheduleElement> getElements() throws IOException {
    ArrayList<ScheduleElement> scheduleListToReturn = new ArrayList<ScheduleElement>();

    BufferedReader br = new BufferedReader(new InputStreamReader(mManager.open("data.txt")));

    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
      ScheduleElement scheduleElement = ScheduleElement.parseFromString(line);
      scheduleListToReturn.add(scheduleElement);
    }
    return scheduleListToReturn;
  }

}
