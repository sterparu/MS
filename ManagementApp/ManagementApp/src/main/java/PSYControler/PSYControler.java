package PSYControler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pojo.client;

import java.util.List;

public class PSYControler {
    @Autowired
    private final service.clientService clientService;

    public PSYControler(service.clientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    public List<client> getClients() {
        return clientService.getclients();
    }

    @PostMapping(path="/add")
    public int addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping(path="/edit/{id}")
    public void editBook(@PathVariable(name="id") String id, @RequestBody Book book){
        bookService.editBook(id, book);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
        return new ResponseEntity("The book was successfully removed", HttpStatus.NO_CONTENT);
    }
}