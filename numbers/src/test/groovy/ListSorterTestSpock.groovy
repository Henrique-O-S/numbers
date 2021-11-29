import com.aor.numbers.ListAggregator
import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListSorterTestSpock extends Specification{
    private List<Integer> list
    private List<Integer> expected

    def "setup"() {
        this.list = Arrays.asList(3, 2, 6, 1, 4, 5, 7, 3, -3)
        this.expected = Arrays.asList(-3, 1, 2, 3, 3, 4, 5, 6, 7)
    }

    def "sort"() {

        given:
        def sorter = new ListSorter();


        when:
        def sorted = sorter.sort(list)

        then:
        sorted == expected
    }

    def "sort_bug_8726"() {

        given:
        def bug_list = Arrays.asList(1, 2, 4, 2)
        def sorter = new ListSorter()

        when:
        def sorted = sorter.sort(bug_list)

        then:
        sorted == [1, 2, 2, 4]
    }
}
