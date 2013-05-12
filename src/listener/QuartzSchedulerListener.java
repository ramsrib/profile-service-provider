package listener;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;



public class QuartzSchedulerListener implements ServletContextListener {
    

    public void contextInitialized(ServletContextEvent arg0) {

            JobDetail job = JobBuilder.newJob(job.TestJob.class)
                    .withIdentity("anyJobName", "group1").build();

            try {

                    Trigger trigger = TriggerBuilder
                      .newTrigger()
                      .withIdentity("anyTriggerName", "group1")
                      .withSchedule(
                         CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                      .build();

                    Scheduler scheduler = new StdSchedulerFactory().getScheduler();
                    scheduler.start();
                    scheduler.scheduleJob(job, trigger);

            } catch (SchedulerException e) {
                    e.printStackTrace();
            }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
    public void printScheduler() throws SchedulerException {
        
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        
        for (String groupName : scheduler.getJobGroupNames()) {
      
          for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
      
               String jobName = jobKey.getName();
               String jobGroup = jobKey.getGroup();
      
               //get job's trigger
               List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
               Date nextFireTime = triggers.get(0).getNextFireTime(); 
      
                     System.out.println("[jobName] : " + jobName + " [groupName] : "
                             + jobGroup + " - " + nextFireTime);
      
               }
      
         }
    }
}

