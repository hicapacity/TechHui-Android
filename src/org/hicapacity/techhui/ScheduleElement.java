package org.hicapacity.techhui;

/**
 * @author Jason Axelson
 * 
 */
public class ScheduleElement {
  private String mTitle;
  private String mTime;
  private String mTrack;

  public ScheduleElement(String title, String time, String track) {
    System.out.println("creating schedule element with title=" + title + " time=" + time
        + " track=" + track);
    mTitle = title;
    mTime = time;
    mTrack = track;
    System.out.println(this.toString());
  }

  /**
   * Expected input example:
   * "Time=9am-10:15am,One=Keynote: Geometric Theory of Everything"
   * @param input
   * @return the created {@link ScheduleElement}
   */
  public static ScheduleElement parseFromString(String input) {
    String[] split = input.split(",", 2);
    System.out.println("First split is: " + split[0]);
    String timeString = split[0];
    String time = ScheduleElement.parseTime(timeString);

    String descriptionString = split[1];
    String description = ScheduleElement.parseDescription(descriptionString);

    String trackString = split[1];
    String track = ScheduleElement.parseTrack(trackString);

    return new ScheduleElement(description, time, track);
  }

  public static String parseTime(String timeString) {
    if (timeString.startsWith("Time=")) {
      String[] split = timeString.split("Time=");
      String toReturn = split[1];
      System.out.println("parse time from < " + timeString + " > got < " + toReturn + " >");
      return toReturn;
    }
    else {
      return "NullTime";
    }
  }

  /**
   * Example input: "One=Keynote: Geometric Theory of Everything"
   * @param descriptionString
   * @return
   */
  public static String parseDescription(String descriptionString) {
    String[] split = descriptionString.split("=");
    String description = split[1];
    return description;
  }

  public static String parseTrack(String trackString) {
    if (trackString.startsWith("One=")) {
      return "one";
    }
    else if (trackString.startsWith("Two=")) {
      return "two";
    }
    else {
      String message = "Unable to parse track from: " + trackString;
      System.out.println(message);
      throw new RuntimeException(message);
    }
  }

  public String getShortDescription() {
    int max = 40;
    String string = mTime + " " + mTitle;
    System.out.println("short descriptiont string is=" + string);
    if (string.length() >= max) {
      return string.substring(0, max);
    }
    else {
      return string;
    }
  }

  public String getFullDescription() {
    String string = mTime + mTitle;
    return string;
  }

  /**
   * @return the mTitle
   */
  public String getTitle() {
    return mTitle;
  }

  /**
   * @param mTitle the mTitle to set
   */
  public void setmTitle(String mTitle) {
    this.mTitle = mTitle;
  }

  /**
   * @return the mTime
   */
  public String getTime() {
    return mTime;
  }

  /**
   * @param mTime the mTime to set
   */
  public void setmTime(String mTime) {
    this.mTime = mTime;
  }

  /**
   * @return the mTrack
   */
  public String getmTrack() {
    return mTrack;
  }

  /**
   * @param mTrack the mTrack to set
   */
  public void setmTrack(String mTrack) {
    this.mTrack = mTrack;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return this.getShortDescription();
  }
}
