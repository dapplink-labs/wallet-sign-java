package xyz.dapplink.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.dapplink.server.algorithm.EcDSAStrategy;
import xyz.dapplink.server.algorithm.dto.PairEntity;

@SpringBootTest
public class WalletSignServerTest {

    @Autowired
    private EcDSAStrategy ecDSAStrategy;

    @Test
    public void testEcDSAStrategy() throws Exception {
        PairEntity pair = ecDSAStrategy.generateKeygen();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>pair:" + pair);
    }

}
