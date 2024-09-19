package at.medunigraz.damap.rest.projects;

import at.medunigraz.api.rest.base.models.MUGSearchResult;
import at.medunigraz.api.rest.base.services.MUGAPIServiceBase;
import at.medunigraz.damap.rest.dmp.domain.MUGProject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.time.Instant;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "rest.projects")
public interface MUGProjectRestService extends MUGAPIServiceBase<MUGProject> {
  @GET
  @Path("")
  @ClientHeaderParam(name = "accept", value = "application/json")
  MUGSearchResult<MUGProject> search(
      @QueryParam("title") String title,
      @QueryParam("end_effective__gte") Instant endEffective,
      @QueryParam("offset") int offset,
      @QueryParam("limit") int limit);
}
