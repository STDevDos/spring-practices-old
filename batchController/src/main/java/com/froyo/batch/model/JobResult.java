package com.froyo.batch.model;

import java.io.Serializable;

/**
 * Use for show the status after execute job.
 *
 * @author Froy
 */
public class JobResult implements Serializable {

    private static final long serialVersionUID = -2907919676999053377L;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("JobResult [status=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }


}
