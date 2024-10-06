package xyz.dapplink.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.dapplink.server.algorithm.BLSStrategy;
import xyz.dapplink.server.algorithm.EcDSAStrategy;
import xyz.dapplink.server.algorithm.EdDSAStrategy;
import xyz.dapplink.server.algorithm.RSAStrategy;
import xyz.dapplink.server.algorithm.dto.PairEntity;

@SpringBootTest
public class WalletSignServerTest {

    @Autowired
    private EcDSAStrategy ecDSAStrategy;

    @Autowired
    private EdDSAStrategy edDSAStrategy;

    @Autowired
    private RSAStrategy rsaStrategy;

    @Autowired
    private BLSStrategy blsStrategy;

    @Test
    public void testEcDSAStrategy() throws Exception {
        PairEntity pair = ecDSAStrategy.generateKeygen();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>pair:" + pair);
    }

    @Test
    public void testEdDSAStrategy() throws Exception {
        PairEntity pair = edDSAStrategy.generateKeygen();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>pair:" + pair);
    }

    @Test
    public void testRSAStrategy() throws Exception {
        PairEntity pair = rsaStrategy.generateKeygen();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>pair:" + pair);
    }

    @Test
    public void testBLSStrategy() throws Exception {
        PairEntity pair = blsStrategy.generateKeygen();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>pair:" + pair);
    }


}
