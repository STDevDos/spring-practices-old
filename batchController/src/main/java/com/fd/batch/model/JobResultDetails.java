package com.fd.batch.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Use for show the status after execute job.
 *
 * @author Froy
 */
public class JobResultDetails implements Serializable {

    private static final long serialVersionUID = -2907919676999053377L;

    private String status;
    private String JobConfigurationName;
    private Date startTime;
    private Date endTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobConfigurationName() {
        return JobConfigurationName;
    }

    public void setJobConfigurationName(String jobConfigurationName) {
        JobConfigurationName = jobConfigurationName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("JobResultDetails [status=");
        builder.append(status);
        builder.append(", JobConfigurationName=");
        builder.append(JobConfigurationName);
        builder.append(", startTime=");
        builder.append(startTime);
        builder.append(", endTime=");
        builder.append(endTime);
        builder.append("]");
        return builder.toString();
    }


}
