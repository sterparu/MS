package service;

import org.springframework.stereotype.Service;
import pojo.client;
import repository.clientRepo;

import java.util.List;
@Service
public class clientService {
    private final clientRepo clientRepository;

    public clientService(clientRepo clientRepository) {
        this.clientRepository = clientRepository;
    }
    public List<client> getclients() {
        return clientRepository.getClient();
    }

    public int addclient(client client) {
        return clientRepository.addClient(client);
    }

    public void editClient(String id, client newClient) {
        clientRepository.editClient(id, newClient);
    }

    public void deleteClient(String id) {
        clientRepository.deleteClient(id);
    }
}
