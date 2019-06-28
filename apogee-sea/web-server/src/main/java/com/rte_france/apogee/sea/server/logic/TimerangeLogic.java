package com.rte_france.apogee.sea.server.logic;

import com.rte_france.apogee.sea.server.model.timerange.EndType;
import com.rte_france.apogee.sea.server.model.timerange.StartType;
import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TimerangeLogic {

    /**
     * The name of the time range displayed to the user
     */
    @NonNull
    private String name;

    /**
     * The time zone to be used when using a startType or endType MIDNIGHT
     */
    @NonNull
    private String timeZone;

    /**
     * The start time type
     */
    protected StartType startType;

    /**
     * The end time type
     */
    protected EndType endType;

    /**
     * To be set to null if startType=MIDNIGHT.
     * if startType=NOW, set to 30' to have startTime starting at NOW-30', ...
     */
    protected Integer startTimeMinutes;

    /**
     * To be set to null if startType=NOW.
     * if startType=MIDNIGHT, set to 1 to have startTime starting at J+1, 2 for J+2, ...
     */
    private Integer startTimeDay;

    /**
     * To be set to null if startType=NOW.
     * if startType=MIDNIGHT, set to 8 to have startTime starting at J+startTimeDay + 8hours
     */
    private Integer startTimeHour;

    /**
     * To be set to null if endType=HOURRELATIVE.
     * if endType=MIDNIGHT, set to 1 to have endTime finishing at next midnight (J+1 00h00)
     */
    private Integer endTimeDay;

    /**
     * To set to 1 to have endType finishing at next midnight (J+1 00h00)
     */
    private Integer endTimeHour;

    /**
     * Optional feature: If the difference between end time and start time is lower than this number of hours,
     * then switch to the another time range specified in alternateTimerange.
     * Must be set to null to disable the feature.
     */
    private Integer alternateIfLessHoursThan;

    /**
     * Optional feature: If the difference between end time and start time is lower than alternateTimerange hours,
     * then switch to this another time range .
     * Must be set to null to disable the feature.
     */

    private String alternateTimerange;
}
