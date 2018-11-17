package com.codingdojo.templatelogreg.repositories;

import java.util.List;


import com.codingdojo.templatelogreg.models.Show;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{

    // CRUD METHODS

        // CREATE

        // END OF CREATE

        // READ
        
        List<Show> findAll();
        Show findByTitle(String title);
        
        // List<Show> findByDescriptionContaining(String search);
        
        // Long countByTitleContaining(String search);
        
        // END OF READ

        // UPDATE

        // END OF UPDATE

        // DELETE

        // Long deleteByTitleStartingWith(String search);

        // this method deletes a Show by id
        List<Show> deleteById(long id);

        // END OF DELETE

    // END OF CRUD METHODS

}