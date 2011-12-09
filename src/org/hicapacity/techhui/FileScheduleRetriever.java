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
	private List<ScheduleElement> track1 = new ArrayList<ScheduleElement>();
	private List<ScheduleElement> track2 = new ArrayList<ScheduleElement>();
	
	public FileScheduleRetriever(AssetManager manager) throws IOException {
		// some manager?
		mManager = manager;
		
		// read in file on class instantiation
		BufferedReader br = new BufferedReader(new InputStreamReader(mManager.open("data.txt")));
		
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			ScheduleElement scheduleElement = ScheduleElement.parseFromString(line);
			
			if (scheduleElement.getmTrack().equalsIgnoreCase("one")) {
				this.track1.add(scheduleElement);
			}
			
			if (scheduleElement.getmTrack().equalsIgnoreCase("two")) {
				this.track2.add(scheduleElement);
			}
		}
	}

	public List<ScheduleElement> getTrack1Elements() throws IOException {
		return this.track1;
	}

	public List<ScheduleElement> getTrack2Elements() throws IOException {
		return this.track2;
	}

}
