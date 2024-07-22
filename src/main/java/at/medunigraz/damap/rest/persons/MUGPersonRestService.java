package at.medunigraz.damap.rest.persons;

import at.medunigraz.api.rest.base.models.MUGSearchResult;
import at.medunigraz.api.rest.base.services.AuthorizationClientHeadersFactory;
import at.medunigraz.api.rest.base.services.MUGAPIServiceBase;
import at.medunigraz.damap.rest.dmp.domain.MUGPerson;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.util.List;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@ApplicationScoped
@RegisterRestClient(configKey = "rest.persons")
@RegisterClientHeaders(value = AuthorizationClientHeadersFactory.class)
public interface MUGPersonRestService extends MUGAPIServiceBase<MUGPerson> {

  // The API currently applies an AND operation for each filter (i.e.
  // first_name__contains AND last_name__contains). Currenly, we only search
  // for one field, as we do not know how people will search.
  @GET
  @Path("")
  MUGSearchResult<MUGPerson> search(
      @QueryParam("last_name__icontains") String firstName,
      @QueryParam("offset") int offset,
      @QueryParam("limit") int limit,
      @QueryParam("expand") List<String> expand);
}
