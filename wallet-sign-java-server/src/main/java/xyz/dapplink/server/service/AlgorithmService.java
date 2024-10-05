package xyz.dapplink.server.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import xyz.dapplink.server.algorithm.AlgorithmStrategy;
import xyz.dapplink.server.enums.SignType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AlgorithmService {

    private Map<String, AlgorithmStrategy> strategyMap = new ConcurrentHashMap<>();

    @Resource
    public void setStrategyMap(List<AlgorithmStrategy> algorithmStrategies) {
        strategyMap.clear();
        algorithmStrategies.forEach(item -> {
            strategyMap.put(item.getTypeName(), item);
        });
    }

    public AlgorithmStrategy getStrategy(SignType signType){
        return strategyMap.get(signType.getName());
    }

}
