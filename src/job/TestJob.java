package job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println(new java.util.Date().getMinutes() + " Struts 2.3.4 + Quartz 2.1.5");
    }

}
