package de.superchat.subdomains.messaging.adapters.webapp.contacts;

import de.superchat.subdomains.messaging.application.ports.driving.contacts.ContactService;
import de.superchat.subdomains.messaging.domain.model.contacts.Contact;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("contacts")
@Tag(name = "contacts")
public class ContactsResource {

    @Inject ContactService service;

    @GET
    public Uni<List<Contact>> get() {
        return service.getAllContacts();
    }

    @POST
    public Uni<Long> post(Contact contact) {
        return service.createContact(contact);
    }
}
