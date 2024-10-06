package xyz.dapplink.iface.constant;

import io.grpc.Context;


public interface AuthConstant {

    Context.Key<String> AUTH_CLIENT_ID = Context.key("clientId");

    String AUTH_HEADER = "Authorization";

    String AUTH_TOKEN_TYPE = "Bearer";

}
