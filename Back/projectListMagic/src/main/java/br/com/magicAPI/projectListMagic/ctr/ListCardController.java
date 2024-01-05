package br.com.magicAPI.projectListMagic.ctr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.magicAPI.projectListMagic.dao.ListCardRepository;
import br.com.magicAPI.projectListMagic.model.ListCard;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/listCard")
public class ListCardController {
    @Autowired
    private ListCardRepository listCardRepository;

    @GetMapping("/list/{CardId}")
    public Optional<ListCard> getListCard(@PathVariable Integer CardId) {
        return listCardRepository.findById(CardId);
    }

    @GetMapping
    public List<ListCard> getListCards() {
        return listCardRepository.findAll();
    }

    @PostMapping("/list")
    public ListCard insertCard(@RequestBody ListCard listCard){

        return listCardRepository.save(listCard);
    }
}