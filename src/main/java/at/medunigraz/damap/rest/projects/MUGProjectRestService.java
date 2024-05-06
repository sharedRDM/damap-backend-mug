package at.medunigraz.damap.rest.projects;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import at.medunigraz.api.rest.base.models.MUGSearchResult;
import at.medunigraz.api.rest.base.services.MUGAPIServiceBase;
import at.medunigraz.damap.rest.dmp.domain.MUGProject;

@RegisterRestClient(configKey = "rest.projects")
public interface MUGProjectRestService extends MUGAPIServiceBase<MUGProject> {
    @GET
    @Path("")
    @ClientHeaderParam(name = "accept", value = "application/json")
    MUGSearchResult<MUGProject> search(@QueryParam("title__contains") String title, @QueryParam("offset") int offset,
            @QueryParam("limit") int limit);
}
