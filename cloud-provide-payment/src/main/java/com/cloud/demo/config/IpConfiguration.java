package com.cloud.demo.config;

import lombok.Getter;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lw
 * @description 获得端口号
 * @date 2021-12-09 16:47
 */
@Component
@Getter
public class IpConfiguration implements ApplicationListener<WebServerInitializedEvent> {

    /**
     * 端口号
     */
    private int serverPort;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        this.serverPort = webServerInitializedEvent.getWebServer().getPort();
    }


}
