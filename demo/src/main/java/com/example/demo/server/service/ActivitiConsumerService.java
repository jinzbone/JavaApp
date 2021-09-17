package com.example.demo.server.service;

public interface ActivitiConsumerService {
    boolean createDeployment(String resource);
    boolean deleteDeployment(String id);
    boolean queryProcdef();
    boolean startActivityDemo(String key);
    boolean getTaskList(String assignee);
    boolean  complete(String taskId,String message);
    boolean isProcessActive(String taskId);
    boolean  deleteProcessInstance(String runId);
}
