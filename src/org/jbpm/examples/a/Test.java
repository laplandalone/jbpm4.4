package org.jbpm.examples.a;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.api.Configuration;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.jbpm.test.JbpmTestCase;

public class Test extends JbpmTestCase 
{
	  String deploymentId;
	  
	  protected void setUp() throws Exception {
 	    super.setUp();
	    
// 	    deploymentId = repositoryService.createDeployment()
// 	        .addResourceFromClasspath("org/jbpm/examples/a/leave.jpdl.xml")
// 	        .deploy();
	  }
	
	  protected void tearDown() throws Exception {
//		    repositoryService.deleteDeploymentCascade(deploymentId);
//		    
//		    super.tearDown();
		  }
	  
	  public void testTest()
	  {
		    Map map=new HashMap();
			map.put("owner", "t");
			List<ProcessDefinition> processDefitionList=repositoryService.createProcessDefinitionQuery().list();
			String id="";
			for(ProcessDefinition pd : processDefitionList)
			{
				 id=pd.getId();
				 System.out.println("id:"+id);
			}
			executionService.startProcessInstanceById("leave-1",map);
	  }
	
	  public static void main(String[] args) {
		  ProcessEngine processEngine=Configuration.getProcessEngine(); 
		  RepositoryService repositoryService = processEngine.getRepositoryService();
		  List<ProcessDefinition> processDefitionList=repositoryService.createProcessDefinitionQuery().list();
		  String id="";
		  for(ProcessDefinition pd : processDefitionList)
		  {
				 id=pd.getId();
				 System.out.println("id:"+id);
				 System.out.println("name:"+pd.getName());
		  }
		
		  TaskService taskService=processEngine.getTaskService();
		  
		  
		  List<Task> taskList=taskService.findPersonalTasks("manager");
		  String taskId="";
		  for(Task task :taskList)
		  {
		 
				 task.getActivityName() ;
				 task.getFormResourceName() ;
				 taskId=task.getId(); 
				 System.out.println( task.getFormResourceName());
		  }
			
			Map map=new HashMap();
			map.put("day", "1");
			map.put("reason", "有事");
//			taskService.setVariables(taskId, map);
//			taskService.completeTask(taskId);
			 
			
	}
}
