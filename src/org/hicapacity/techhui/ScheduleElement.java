package org.hicapacity.techhui;

/**
 * @author Jason Axelson
 * 
 */
public class ScheduleElement {
  private String mTitle;
  private String mTime;

  public ScheduleElement(String title, String time) {
    mTime = title;
    mTime = time;
  }

  public static ScheduleElement parseFromString(String input) {
    return new ScheduleElement("fake time", input);
  }

  public String getShortDescription() {
    String string = this.getFullDescription();
    return string.substring(0, 20);
  }

  public String getFullDescription() {
    String string = mTime + mTitle;
    return string;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return this.getShortDescription();
  }
}
