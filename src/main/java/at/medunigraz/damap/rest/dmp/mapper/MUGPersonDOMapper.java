package at.medunigraz.damap.rest.dmp.mapper;

import at.ac.tuwien.damap.rest.dmp.domain.ContributorDO;
import at.medunigraz.damap.rest.dmp.domain.MUGPerson;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MUGPersonDOMapper {

    public ContributorDO mapEntityToDO(MUGPerson mugPerson, ContributorDO contributorDO) {
        contributorDO.setFirstName(mugPerson.getFirstName());
        contributorDO.setLastName(mugPerson.getLastName());
        contributorDO.setUniversityId(mugPerson.getId());
        contributorDO.setMbox(mugPerson.getEmail());

        return contributorDO;
    }
}
