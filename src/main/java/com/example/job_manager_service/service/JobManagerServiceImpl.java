package com.example.job_manager_service.service;

import com.example.job_manager_service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobManagerServiceImpl implements JobManagerService {

    private final MongoTemplate mongoTemplate;
    private final QueryService queryService;
    private final ProducerToSendService producerToSendService;

    public String saveJobToBase(UnapprovedJob jobForm, String doc) {

        jobForm.setDataStartJob(LocalDate.now());
        ScheduledJob scheduledJob = new ScheduledJob();
        scheduledJob.setJobType(jobForm.getJobType());

        scheduledJob.setDataStartJob(LocalDate.now());
        mongoTemplate.save(jobForm);
        mongoTemplate.save(scheduledJob, doc);

        return "Работа зарегистрирована, ждёт проверку";
    }

    @Override
    public void saveToPersonBase(ResponsiblePerson person) {

        mongoTemplate.save(person);
    }

    @Override
    public String approveJob(AuthenticationInfo authenticationInfo, LocalDate localDate) {

        ResponsiblePerson responsiblePerson = queryService.getResponsiblePerson(authenticationInfo);

        Query queryJob = queryService.getQueryJob(responsiblePerson.getDistrict(), localDate);

        List<UnapprovedJob> unapprovedJobList = queryService.getUnapprovedJobListByDistrictAndJobStartDate(queryJob);

        for (UnapprovedJob jobForm : unapprovedJobList) {
            ApprovedJob approvedJob = new ApprovedJob();

            approvedJob.setJobDescription(jobForm.getJobDescription());
            approvedJob.setDistrict(jobForm.getDistrict());
            approvedJob.setEmail(jobForm.getEmail());
            approvedJob.setEmployeeName(jobForm.getEmployeeName());
            approvedJob.setDataStartJob(jobForm.getDataStartJob());
            approvedJob.setJobType(jobForm.getJobType());

            approvedJob.setResponsiblePerson(responsiblePerson.getName() + " " + responsiblePerson.getPersonalId());
            mongoTemplate.save(approvedJob);

            mongoTemplate.remove(queryJob, UnapprovedJob.class);
            producerToSendService.sendApprovedJob(approvedJob);
        }

        return "Подтверждение работ прошло успешно";
    }

    @Override
    public List<UnapprovedJob> unapprovedJob(AuthenticationInfo authenticationInfo) {

        ResponsiblePerson responsiblePerson = queryService.getResponsiblePerson(authenticationInfo);
        List<UnapprovedJob> unapprovedJobListByDistrict =
                queryService.getUnapprovedJobListByDistrict(responsiblePerson.getDistrict());


        if (unapprovedJobListByDistrict.isEmpty()) {
            throw new RuntimeException("Нет запланированных работ на вашем участке");
        }
        return unapprovedJobListByDistrict;
    }


}
