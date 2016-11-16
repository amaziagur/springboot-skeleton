package ct.com.crazylabz.boot.spec

import spock.lang.Shared
import spock.lang.Specification

class HelloBootSpec extends Specification {

    public static final String NAME = "bob"

    @Shared
    BootClient bootClient = new BootClient()


    def setupSpec() {
        bootClient.start()
    }

    def "should greet new member by name"(){
        when:
        def response = bootClient.greet(NAME)

        then:
        assert response.message == expectedMessage()
    }

    private String expectedMessage() {
        String.format(bootClient.getServiceProperty("boot.greet.message"), NAME)
    }

}
