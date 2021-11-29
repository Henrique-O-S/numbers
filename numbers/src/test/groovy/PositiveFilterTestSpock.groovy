import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class PositiveFilterTestSpock extends Specification{

    def "accepted"() {

        given:
        def number = 1
        def filter = new PositiveFilter()

        expect:
        filter.accept(number) == true
    }

    def "unaccepted"() {

        given:
        def number = -1
        def zero = 0
        def filter = new PositiveFilter()

        expect:
        filter.accept(number) == false
        filter.accept(zero) == false
    }
}
