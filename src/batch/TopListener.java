package batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

@WebListener
public class TopListener implements ServletContextListener {
	
	/* field */
	private Scheduler scheduler;
	
	/* constructor */
	public TopListener() {
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* method */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
    		if (scheduler != null) {
    			scheduler.shutdown();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
    		JobDetail job = JobBuilder.newJob(TopJob.class)
    				.withIdentity("job4", "group4")
    				.build();
    		
    		// 2. Trigger
    		Trigger trigger = TriggerBuilder.newTrigger()	// (String name, String group) ("등록이름", "등록그룹")
    				.withIdentity("trigger4", "group4")
    				.withSchedule(CronScheduleBuilder.cronSchedule("0 29 11 1/1 * ? *"))
    				.build();
    		// 3. scheduler에 job과 trigger등록
    		//		  scheduleJob(JobDetail arg0, Trigger arg1) throws SchedulerException
    		scheduler.scheduleJob(job, trigger);
    		
    		// 4. scheduler 실행 시작
    		scheduler.start();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
	
}
