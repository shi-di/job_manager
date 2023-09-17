package com.example.job_manager_service.service;

import com.example.job_manager_service.application_exception.NotFoundPasswordAndIdException;
import com.example.job_manager_service.application_exception.NotFoundUnapprovedJobException;
import com.example.job_manager_service.model.AuthenticationInfo;
import com.example.job_manager_service.model.ResponsiblePerson;
import com.example.job_manager_service.model.UnapprovedJob;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryService {

    private final MongoTemplate mongoTemplate;

    public List<UnapprovedJob> getUnapprovedJobListByDistrict(String district) {

        Query queryJob = new Query(Criteria.where("district").is(district));
        List<UnapprovedJob> unapprovedJobList = mongoTemplate.find(queryJob, UnapprovedJob.class);

        if (unapprovedJobList.isEmpty()) {
            throw new NotFoundUnapprovedJobException();
        }
        return unapprovedJobList;
    }

    public Query getQueryJob(String district, LocalDate startJobDate) {

        Query queryJob = new Query(Criteria.where("district").is(district)
                .and("dataStartJob").is(startJobDate));

        return queryJob;
    }

    public List<UnapprovedJob> getUnapprovedJobListByDistrictAndJobStartDate(Query queryJob) {


        List<UnapprovedJob> jobForms = mongoTemplate.find(queryJob, UnapprovedJob.class);

        if (jobForms.isEmpty()) {
            throw new NotFoundUnapprovedJobException();
        }
        return jobForms;
    }

    public ResponsiblePerson getResponsiblePerson(AuthenticationInfo authenticationInfo) {

        Query queryPerson = new Query(Criteria.where("personalId").is(authenticationInfo.getPersonalId())
                .and("approvePassword").is(authenticationInfo.getApprovePassword()));

        List<ResponsiblePerson> responsiblePerson = mongoTemplate.find(queryPerson, ResponsiblePerson.class);

        if (responsiblePerson.isEmpty()) {
            throw new NotFoundPasswordAndIdException();
        }

        return responsiblePerson.get(0);

    }

}
