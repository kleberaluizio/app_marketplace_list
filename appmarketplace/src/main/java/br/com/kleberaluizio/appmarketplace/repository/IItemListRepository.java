package br.com.kleberaluizio.appmarketplace.repository;

import br.com.kleberaluizio.appmarketplace.model.ItemList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface IItemListRepository extends CrudRepository<ItemList, Integer> {
}
