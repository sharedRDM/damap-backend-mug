package at.medunigraz.api.rest.base.services;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class AuthorizationClientHeadersFactory implements ClientHeadersFactory {

    @ConfigProperty(name = "damap.mug.api.auth.token")

    Optional<String> authToken;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders,
            MultivaluedMap<String, String> clientOutgoingHeaders) {
        MultivaluedMap<String, String> result = new MultivaluedHashMap<>();
        if (authToken.isPresent() && !authToken.get().trim().isEmpty()) {
            // Add authorization header if token is set in config
            result.add("Authorization", authToken.get());
        }
        return result;
    }
}
