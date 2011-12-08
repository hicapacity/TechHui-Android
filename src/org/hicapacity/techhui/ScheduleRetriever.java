package org.hicapacity.techhui;

import java.io.IOException;
import java.util.List;

/**
 * @author Jason Axelson
 *
 */
public interface ScheduleRetriever {

  /**
   * @return elements in the schedule
   * @throws IOException
   */
  public List<ScheduleElement> getElements() throws IOException;
}
