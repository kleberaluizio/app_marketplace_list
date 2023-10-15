package br.com.kleberaluizio.appmarketplace.service;

import br.com.kleberaluizio.appmarketplace.model.ItemList;
import br.com.kleberaluizio.appmarketplace.repository.IItemListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemListServiceImpl implements IItemListService {

    @Autowired
    private IItemListRepository repository;

    @Override
    public ItemList insertItem(ItemList item) {
        return repository.save(item);
    }

    @Override
    public ItemList updateItem(ItemList item) {
        return repository.save(item);
    }

    @Override
    public void deleteItem(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ItemList findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
