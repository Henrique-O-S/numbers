import com.aor.numbers.ListAggregator
import spock.lang.Specification
import com.aor.numbers.GenericListDeduplicator

class ListAggregatorTestSpock extends Specification {
    private List<Integer> list;

    def "setup"() {
        this.list = Arrays.asList(1,2,4,2,5)
    }

    def "distinct" () {

        given:
        def aggregator = new ListAggregator()


        when:
        def distinct = aggregator.distinct(list);

        then:
        distinct == 4
    }

    def "distinct_bug_8726"() {

        given:
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 4)

        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))

        then:
        result == Arrays.asList(1,2,4)
    }

}
