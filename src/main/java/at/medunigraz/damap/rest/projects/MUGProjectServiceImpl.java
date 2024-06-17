package at.medunigraz.damap.rest.projects;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import at.ac.tuwien.damap.rest.base.ResultList;
import at.ac.tuwien.damap.rest.base.Search;
import at.ac.tuwien.damap.rest.dmp.domain.ContributorDO;
import at.ac.tuwien.damap.rest.dmp.domain.ProjectDO;
import at.ac.tuwien.damap.rest.projects.ProjectService;
import at.ac.tuwien.damap.rest.projects.ProjectSupplementDO;
import at.medunigraz.damap.rest.dmp.domain.MUGPerson;
import at.medunigraz.damap.rest.dmp.domain.MUGProject;
import at.medunigraz.damap.rest.dmp.mapper.MUGPersonDOMapper;
import at.medunigraz.damap.rest.dmp.mapper.MUGProjectDOMapper;
import at.medunigraz.damap.rest.persons.MUGPersonRestService;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class MUGProjectServiceImpl implements ProjectService {

    @Inject
    @RestClient
    MUGPersonRestService personRestService;

    @Inject
    @RestClient
    MUGProjectRestService projectRestService;

    @Override
    public ResultList<ProjectDO> search(MultivaluedMap<String, String> queryParams) {
        Search s = Search.fromMap(queryParams);
        List<ProjectDO> projects = List.of();
        int limit = s.getPagination().getPerPage();
        int offset = ((s.getPagination().getPage() < 1 ? 1 : s.getPagination().getPage()) - 1) * limit;

        try {
            var mugProjects = projectRestService.search(s.getQuery(), new Date().toInstant(), offset, limit);

            projects = mugProjects.getResults().stream().map(p -> MUGProjectDOMapper.mapEntityToDO(p, new ProjectDO()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.warn("Error during Project search: " + e);
        }

        return ResultList.fromItemsAndSearch(projects, s);
    }

    @Override
    public List<ContributorDO> getProjectStaff(String projectId) {
        MUGProject project = projectRestService.read(projectId, null);
        List<String> personIDs = project.getPersons().stream().map(input -> input.split("-")[1])
                .collect(Collectors.toList());

        var unis = personIDs.stream()
                .map(personID -> Uni.createFrom().item(() -> personRestService.read(personID, null))
                        .emitOn(Infrastructure.getDefaultExecutor()));

        var persons = Uni.join().all(unis.collect(Collectors.toList())).andCollectFailures()
                .await().atMost(Duration.ofSeconds(10));

        log.info(persons);

        return persons.stream().map(mugPerson -> MUGPersonDOMapper.mapEntityToDO(mugPerson, new ContributorDO()))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDO read(String id, MultivaluedMap<String, String> queryParams) {
        return this.read(id, queryParams, null);
    }

    public ProjectDO read(String id, MultivaluedMap<String, String> queryParams, List<String> expand) {
        var project = projectRestService.read(id, expand);
        return MUGProjectDOMapper.mapEntityToDO(project, new ProjectDO());
    }

    @Override
    public ResultList<ProjectDO> getRecommended(MultivaluedMap<String, String> queryParams) {
        return this.search(queryParams);
    }

    @Override
    public ProjectSupplementDO getProjectSupplement(String projectId) {
        return null;
    }

    @Override
    public ContributorDO getProjectLeader(String projectId) {
        return null;
    }
}
