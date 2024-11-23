package br.com.scaa.asscache.repository;

import br.com.scaa.asscache.model.AssinaturaCacheModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaCacheRepository extends CrudRepository<AssinaturaCacheModel, Long> {
}
