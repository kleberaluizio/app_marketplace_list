package br.com.kleberaluizio.appmarketplace.repository;

import br.com.kleberaluizio.appmarketplace.model.ListOfItems;
import org.springframework.data.repository.CrudRepository;

public interface IListRepository extends CrudRepository<ListOfItems, Integer> {
}
