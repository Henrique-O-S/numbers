import com.aor.numbers.ListAggregator
import spock.lang.Specification
import com.aor.numbers.GenericListDeduplicator

class ListAggregatorTestSpock extends Specification {
    private List<Integer> list;

    def "setup"() {
        this.list = Arrays.asList(1,2,4,2,5)
    }

    def "sum"() {

        given:
        def aggregator = new ListAggregator()


        when:
        def sum = aggregator.sum(list)

        then:
        sum == 14
    }

    def "max"(){

        given:
        def aggregator = new ListAggregator()


        when:
        def max = aggregator.max(list);

        then:
        max == 5
    }

    def "min" () {

        given:
        def aggregator = new ListAggregator()


        when:
        def min = aggregator.min(list);

        then:
        min == 1
    }

    def "distinct" () {

        given:
        def aggregator = new ListAggregator()


        when:
        def distinct = aggregator.distinct(list)

        then:
        distinct == 4
    }

    def "max_bug_7263"() {

        given:
        def bug_list = [-1, -4, -5]
        def aggregator = new ListAggregator()


        when:
        def max = aggregator.max(bug_list);

        then:
        max == -1
    }

    def "distinct_bug_8726"() {

        given:
        def bug_list = [1, 2, 4, 2]
        def aggregator = new ListAggregator()
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 4)

        when:
        def distinct = aggregator.distinct(bug_list, deduplicator)

        then:
        distinct == 3
    }

}
