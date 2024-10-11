package at.medunigraz.api.rest.base.services;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;

// TODO: Use this and the search method to have a common method, which can be reused.
// import org.jboss.resteasy.reactive.RestQuery;

@Produces(MediaType.APPLICATION_JSON)
@RegisterClientHeaders(value = AuthorizationClientHeadersFactory.class)
public interface MUGAPIServiceBase<T> {
  // @GET
  // @Path("")
  // @Consumes(value = "application/json")
  // MUGSearchResult<T> search(@RestQuery MultivaluedMap<String, String>
  // searchQuery, @QueryParam("offset") int offset);

  @GET
  @Path("/{id}")
  @Consumes(value = "application/json")
  T read(@PathParam("id") String id, @QueryParam("expand") List<String> expand);
}
