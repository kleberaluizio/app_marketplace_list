package br.com.kleberaluizio.appmarketplace.service;

import br.com.kleberaluizio.appmarketplace.model.ItemList;
import br.com.kleberaluizio.appmarketplace.model.ListOfItems;
import br.com.kleberaluizio.appmarketplace.repository.IListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ListServiceImpl implements IListService{

    @Autowired
    private IListRepository repository;

    @Override
    public ListOfItems createNewList(ListOfItems listOfItems) {
        return repository.save(listOfItems);
    }

    @Override
    public void deleteList(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ListOfItems closeList(Integer id) {
        ListOfItems l = repository.findById(id).get();
        double total = 0.0;
        for(ItemList item : l.getItems()){
            total += l.getTotalValue();
        }
        l.setTotalValue(total);
        l.setStatus(1);
        return repository.save(l);
    }

    @Override
    public ListOfItems findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ListOfItems> findAll() {
        return (List<ListOfItems>) repository.findAll();
    }
}
