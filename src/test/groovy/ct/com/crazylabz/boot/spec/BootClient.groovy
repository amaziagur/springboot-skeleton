package ct.com.crazylabz.boot.spec

import com.crazylabz.Application
import com.crazylabz.entities.MessageResponse
import groovyx.net.http.RESTClient
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext

class BootClient {
    static def CONTEXT_PATH = "hello-boot/"

    RESTClient client
    ConfigurableApplicationContext service

    def start(String... args) {
        service = SpringApplication.run(Application.class, args)
        client = new RESTClient("http://localhost:8080/")
    }

    def String getServiceProperty(String propName) {
        return service.environment.getProperty(propName)
    }

    def stop() {
        service.close()
    }

    def greet(name) {
        def res = client.get([
                path: CONTEXT_PATH + name,
                contentType: "application/json"
        ])

        assert res.status == 200

        return res.responseData as MessageResponse
    }

}
