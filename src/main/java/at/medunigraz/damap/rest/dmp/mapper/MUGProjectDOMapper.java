package at.medunigraz.damap.rest.dmp.mapper;

import at.ac.tuwien.damap.rest.dmp.domain.ProjectDO;
import at.medunigraz.damap.rest.dmp.domain.MUGProject;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MUGProjectDOMapper {

    public ProjectDO mapEntityToDO(MUGProject project, ProjectDO projectDO) {
        projectDO.setUniversityId(project.getIdentifier());
        projectDO.setTitle(project.getName());
        projectDO.setDescription(project.getDescription());
        projectDO.setStart(project.getStartDate());
        projectDO.setEnd(project.getEndDate());

        return projectDO;
    }
}
