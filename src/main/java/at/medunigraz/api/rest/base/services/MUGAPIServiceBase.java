package at.medunigraz.api.rest.base.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
