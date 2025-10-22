package greedy;

import java.util.Arrays;

public class NMeetings {

    public int findMaxMeetingOrganized(int[] startTime, int[] endTime) {
        Meeting[] meetings = new Meeting[startTime.length];
        int count = 0;

        for (int i = 0 ; i < startTime.length; i++) {
            meetings[i] = new Meeting(startTime[i], endTime[i]);
        }

        Arrays.sort(meetings, (a, b) -> a.end - b.end);
        Meeting currentMeeting = new Meeting(-1,-1);
        for(Meeting meeting : meetings) {
            if (meeting.start > currentMeeting.end) {
                count++;
                currentMeeting = meeting;
            }
        }
        return count;
    }
}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
