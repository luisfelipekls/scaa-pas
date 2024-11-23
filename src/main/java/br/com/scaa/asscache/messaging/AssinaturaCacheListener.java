package br.com.scaa.asscache.messaging;

import br.com.scaa.asscache.model.AssinaturaCacheModel;
import br.com.scaa.asscache.service.AssinaturaCacheService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AssinaturaCacheListener {

    private final AssinaturaCacheService cacheService;

    public AssinaturaCacheListener(AssinaturaCacheService cacheService) {
        this.cacheService = cacheService;
    }

    @RabbitListener(queues = "${rabbitmq.routingkey.assinatura}")
    public void handleAssinaturaUpdate(AssinaturaCacheModel assinaturaCache) {
        cacheService.save(assinaturaCache);
    }
}
