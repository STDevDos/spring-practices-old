package com.fd.batch.service;

import com.fd.batch.model.Tabla1Model;
import com.fd.batch.model.Tabla2Model;
import org.apache.logging.log4j.LogManager;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.fd.batch.model.Utils.LOGGER;


/**
 * Main class for execute Jobs.
 * https://docs.spring.io/spring-batch/trunk/reference/html/metaDataSchema.html
 * http://www.javaboss.it/wp-content/uploads/2016/09/meta-data-erd.png
 *
 * @author Froy
 */
@Configuration
@EnableAutoConfiguration
public class BatchConfig extends DefaultBatchConfigurer {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    /**
     * Persistence
     * <p>
     * The moment a Batch is executed for the first time, a JobExecution is generated through the
     * JobRepository and during its execution the data generated in the StepExecutions and JobExecution are
     * persisted through the JobRepository.
     * <p>
     * https://jira.spring.io/browse/BATCH-2200
     */
    @Override
    protected JobRepository createJobRepository() throws Exception {
        MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean();

        LOGGER = LogManager.getRootLogger();
        LOGGER.info("Start jobServicio :: jobRepository ");

        try {
            factory.afterPropertiesSet();
            return (JobRepository) factory.getObject();
        } catch (Exception e) {
            throw new IllegalStateException("Cannot set MapJobRepositoryFactoryBean (Servicio) : ", e);
        }

    }


    /**
     * @return
     * @throws Exception
     */
    @Bean
    public Job jobUno() throws Exception {

        LOGGER = LogManager.getRootLogger();
        LOGGER.info("Start jobUno :: job ");

        return jobBuilderFactory.get("jobUno")
                .incrementer(new RunIdIncrementer())
                .flow(step1Uno())
                .end()
                .build();
    }

    /**
     * <p>Step: Independent element within a Job.</p>
     * <ul>
     * <li>Each time a Step is executed a new StepExecution is created.</li>
     * <li>Status: Indicates the status of a Step. Their values will vary between STARTED, FAILED or COMPLETED.</li>
     * <li>exitStatus: Contains the Step exit code.</li>
     * </ul>
     * Chuck The number of items that will be processed before the transaction is
     * committed.
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Qualifier("step1Uno")
    public Step step1Uno() throws Exception {

        LOGGER = LogManager.getRootLogger();
        LOGGER.info("Start jobUno :: step1 ");

        return stepBuilderFactory.get("step1Uno")
                .<Tabla1Model, Tabla1Model>chunk(500)
                .reader(readerUno(null))
                // .processor(new Processor())	Optional component for data processing.
                .writer(writerUno(null)).build();
    }

    /**
     * Optional component for data processing.
     * ItemReader<Tabla1Model>
     *
     * @return
     */
    @Bean
    @StepScope
    public JdbcCursorItemReader<Tabla1Model> readerUno(@Value("#{jobParameters[parametro1]}") String parametro1) {

        LOGGER = LogManager.getRootLogger();
        LOGGER.info("Start jobUno :: reader ");

        JdbcCursorItemReader<Tabla1Model> databaseReader = new JdbcCursorItemReader<>();

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("select * from table");

        databaseReader.setDataSource(dataSource);
        databaseReader.setSql(sbQuery.toString());

        databaseReader.setRowMapper(new RowMapper<Tabla1Model>() {
            @Override
            public Tabla1Model mapRow(ResultSet rs, int rowNum) throws SQLException {

                Tabla1Model item = new Tabla1Model();

                item.setColumna1(rs.getInt("columna1"));
                item.setColumna2(rs.getString("columna2"));

                return item;

            }
        });

        return databaseReader;

    }

    /**
     * The ItemWriter that processes the items provided by the ItemReader.
     * <p>
     * Optional component for data processing.
     *
     * @param dataSource
     * @return
     */
    @Bean
    @StepScope
    public JdbcBatchItemWriter<Tabla1Model> writerUno(@Value("#{jobParameters[parametro1]}") String parametro1) {

        LOGGER = LogManager.getRootLogger();
        LOGGER.info("Start jobUno :: writer ");

        JdbcBatchItemWriter<Tabla1Model> writer = new JdbcBatchItemWriter<>();

        writer.setAssertUpdates(false); //org.springframework.dao.EmptyResultDataAccessException: Item 2 of 20

        writer.setDataSource(dataSource);
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Tabla1Model>());

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("update .. ");

        writer.setSql(sbQuery.toString());

        return writer;
    }

    /**
     * @return
     * @throws Exception
     */
    @Bean
    public Job jobDos() throws Exception {

        LOGGER = LogManager.getRootLogger();
        LOGGER.info("Start jobDos :: job ");

        return jobBuilderFactory.get("jobDos")
                .incrementer(new RunIdIncrementer())
                .flow(step1Dos())
                .end()
                .build();
    }

    /**
     * <p>Step: Independent element within a Job.</p>
     * <ul>
     * <li>Each time a Step is executed a new StepExecution is created.</li>
     * <li>Status: Indicates the status of a Step. Their values will vary between STARTED, FAILED or COMPLETED.</li>
     * <li>exitStatus: Contains the Step exit code.</li>
     * </ul>
     * Chuck The number of items that will be processed before the transaction is
     * committed.
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Qualifier("step1Dos")
    public Step step1Dos() throws Exception {

        LOGGER = LogManager.getRootLogger();
        LOGGER.info("Start jobDos :: step1Dos ");

        return stepBuilderFactory.get("step1Dos")
                .<Tabla2Model, Tabla2Model>chunk(1000)
                .reader(readerDos())
                // .processor(new Processor())	Optional component for data processing.
                .writer(writerDos()).build();
    }

    /**
     * Optional component for data processing.
     *
     * @return
     */
    @Bean
    public ItemReader<Tabla2Model> readerDos() {

        LOGGER = LogManager.getRootLogger();
        LOGGER.info("Start jobDos :: reader ");

        JdbcCursorItemReader<Tabla2Model> databaseReader = new JdbcCursorItemReader<>();

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("select * from table ");

        databaseReader.setDataSource(dataSource);
        databaseReader.setSql(sbQuery.toString());

        databaseReader.setRowMapper(new RowMapper<Tabla2Model>() {
            @Override
            public Tabla2Model mapRow(ResultSet rs, int rowNum) throws SQLException {

                Tabla2Model item = new Tabla2Model();

                item.setColumna1(rs.getInt("columna1"));
                item.setColumna2(rs.getString("columna2"));


                return item;

            }
        });

        return databaseReader;

    }

    /**
     * The ItemWriter that processes the items provided by the ItemReader.
     * <p>
     * Optional component for data processing.
     *
     * @param dataSource
     * @return
     */
    @Bean
    public ItemWriter<Tabla2Model> writerDos() {

        LOGGER = LogManager.getRootLogger();
        LOGGER.info("Start jobDos :: writer ");


        JdbcBatchItemWriter<Tabla2Model> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Tabla2Model>());

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("update .... ");

        writer.setSql(sbQuery.toString());
        writer.setDataSource(dataSource);


        return writer;
    }


}
