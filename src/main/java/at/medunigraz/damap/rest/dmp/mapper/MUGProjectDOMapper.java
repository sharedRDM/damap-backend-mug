package at.medunigraz.damap.rest.dmp.mapper;

import at.ac.tuwien.damap.rest.dmp.domain.ProjectDO;
import at.medunigraz.damap.rest.dmp.domain.MUGProject;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

@Log
@UtilityClass
public class MUGProjectDOMapper {

    public ProjectDO mapEntityToDO(MUGProject project, ProjectDO projectDO) {
        projectDO.setAcronym(project.getAcronym());
        projectDO.setDescription(project.getDescription().getDe());
        projectDO.setEnd(project.getEndDate());
        projectDO.setStart(project.getStartDate());
        projectDO.setTitle(project.getName().getDe());
        projectDO.setUniversityId(project.getId());

        return projectDO;
    }
}
