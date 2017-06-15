package greedy;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by neagrawa on 6/14/17.
 */
public class ActivitySelection extends TestCase {
    public List<Job> getMaximumActivities(List<Job> jobs){

        Collections.sort(jobs, Job.JobComparator);
        List<Job> maxJobs = new ArrayList<>();
        Job prevJob = jobs.get(0);
        maxJobs.add(prevJob); //select first job greedily
        for(Job job: jobs){
            if(job.start>=prevJob.end){
                maxJobs.add(job);
                prevJob = job;
            }
        }
        return maxJobs;
    }

    public void testGetActivities(){
        List<Job> availableJobs = new ArrayList<>();
        availableJobs.add(new Job(0,6));
        availableJobs.add(new Job(1,2));
        availableJobs.add(new Job(5,9));
        availableJobs.add(new Job(5,7));
        availableJobs.add(new Job(3,4));
        availableJobs.add(new Job(8,9));

        List<Job> activitiesPossible = getMaximumActivities(availableJobs);
        for(Job job: activitiesPossible){
            System.out.println(job.toString());
        }
    }
}

class Job{
    int start;
    int end;

    public Job(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override public String toString() {
        return "Job{" + start+", "
                      + end +
                '}';
    }

    public static Comparator<Job> JobComparator = new Comparator<Job>() {
        @Override public int compare(Job o1, Job o2) {
            if(o1.end == o2.end){
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        }
    };
}
