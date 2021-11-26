import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import spock.lang.Specification

class ListDeduplicatorTestSpock extends Specification {
    private List<Integer> list
    private List<Integer> expected

    def "setup"() {
        this.list = Arrays.asList(1,2,4,2,5)
        this.expected = Arrays.asList(1,2,4,5)
    }

    def "deduplicate"() {

        given:
        def deduplicator = new ListDeduplicator()
        def sorter = Mock(GenericListSorter)
        sorter.sort(list) >> Arrays.asList(1, 2, 2, 4, 5)

        when:
        def distinct = deduplicator.deduplicate(list, sorter)

        then:
        distinct == expected
    }

    def "deduplicate_bug_8726"() {

        given:
        def bug_list = Arrays.asList(1, 2, 4, 2);
        def deduplicator = new ListDeduplicator()
        def sorter = Mock(GenericListSorter)
        sorter.sort(bug_list) >> Arrays.asList(1, 2, 2, 4)

        when:
        def distinct = deduplicator.deduplicate(bug_list, sorter)

        then:
        distinct == Arrays.asList(1, 2, 4)
    }
}
