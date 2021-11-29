import com.aor.numbers.DivisibleByFilter
import spock.lang.Specification

class DivisibleByFilterTestSpock extends Specification{
    private int number

    def "setup"() {
        this.number = 5
    }

    def "accepted"() {

        given:
        def filter = new DivisibleByFilter(number)

        when:
        def accept_1 = filter.accept(10)
        def accept_2 = filter.accept(0)

        then:
        accept_1 == true
        accept_2 == true
    }

    def "unaccepted"() {

        given:
        def filter = new DivisibleByFilter(number)

        when:
        def accept_1 = filter.accept(13)

        then:
        accept_1 == false
    }
}
