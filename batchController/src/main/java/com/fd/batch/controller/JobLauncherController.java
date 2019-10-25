package com.fd.batch.controller;

import com.fd.batch.model.JobResult;
import com.fd.batch.service.BatchConfig;
import org.apache.logging.log4j.LogManager;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.fd.batch.model.Utils.LOGGER;
import static com.fd.batch.model.Utils.UNEXPECTED_ERROR;

/**
 * Main Controller.
 * es: https://github.com/maldiny/Spring-Batch-en-Castellano/blob/master/README.md#%C3%8Dndice
 *
 * @author Froy
 */
@RestController
public class JobLauncherController {

    /**
     * <p>Component in charge of launching the processes providing the desired input parameters.</p>
     */
    @Autowired
    private JobLauncher jobLauncher;

    /**
     * <p>The job is a container of steps to follow.</p>
     * <ul>
     * <li>A process (Job) must have at least one step.</li>
     * </ul>
     *
     * @see BatchConfig#jobUno()
     */
    @Autowired
    @Qualifier("jobUno")
    private Job jobUno;

    /**
     * @see BatchConfig#jobDos()
     */
    @Autowired
    @Qualifier("jobDos")
    private Job jobDos;

    /**
     * Use for check the status.
     */
    private JobExecution jobExecutionUno;
    private JobExecution jobExecutionDos;

    /**
     * Run Job
     * /jobUno/parametro1
     * /jobUno
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/job{servicio}", "/job{servicio}/{parametro1}"}, method = RequestMethod.GET)
    @ResponseBody
    public JobResult jobService(
            @PathVariable(value = "servicio") String servicio,
            @PathVariable(value = "parametro1") Optional<String> parametro1
    ) throws Exception {

        JobResult jobResult = new JobResult();

        LOGGER = LogManager.getRootLogger();
        LOGGER.info("Start job" + servicio + " :: ");

        try {


            /**
             * JobParameters: parameters to send a job.
             * It can be used to identify an execution or to provide data to the execution itself.
             */
            String _parametro1 = parametro1.isPresent() ? parametro1.get() : null;

            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())                                    //Adding time to start.
                    .addString("parametro1", _parametro1)            //Adding corpCode.
                    .toJobParameters();                                                                //Creating JobParameters.

            if ("jobUno".equalsIgnoreCase(servicio)) {
                jobExecutionUno = jobLauncher.run(jobUno, jobParameters);                //Launch Job with parameters.
                jobResult.setStatus(jobExecutionUno.getStatus().toString());
            } else if ("jobDos".equalsIgnoreCase(servicio)) {
                jobExecutionDos = jobLauncher.run(jobDos, jobParameters);            //Launch Job with parameters.
                jobResult.setStatus(jobExecutionDos.getStatus().toString());
            } else {
                jobResult.setStatus(servicio + " JOB NOT FOUND");
            }


        } catch (Exception e) {
            LOGGER.error(UNEXPECTED_ERROR, e);
            jobResult.setStatus(UNEXPECTED_ERROR);
        }

        LOGGER.info("End job" + servicio + " :: ");

        return jobResult;
    }


}
