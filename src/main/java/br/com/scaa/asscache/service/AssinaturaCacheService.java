package br.com.scaa.asscache.service;

import br.com.scaa.asscache.model.AssinaturaCacheModel;
import br.com.scaa.asscache.repository.AssinaturaCacheRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssinaturaCacheService {

    private final AssinaturaCacheRepository cacheRepository;

    public AssinaturaCacheService(AssinaturaCacheRepository cacheRepository) {
        this.cacheRepository = cacheRepository;
    }

    public void save(AssinaturaCacheModel assinaturaCache) {
        cacheRepository.save(assinaturaCache);
    }

    public Optional<AssinaturaCacheModel> findById(Long id) {
        return cacheRepository.findById(id);
    }

    public void deleteById(Long id) {
        cacheRepository.deleteById(id);
    }
}
