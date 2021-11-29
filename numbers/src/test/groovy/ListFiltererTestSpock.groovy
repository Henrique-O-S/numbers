import com.aor.numbers.GenericListFilter
import com.aor.numbers.ListFilterer
import org.mockito.Mockito
import spock.lang.Specification

class ListFiltererTestSpock extends Specification{
    private List<Integer> list

    def "setup"() {
        this.list = Arrays.asList(1,2,4,2,5,0,-5)
    }

    def "filter"() {

        given:
        def filter = Mockito.mock(GenericListFilter.class)
        Mockito.when(filter.accept(Mockito.anyInt())).thenReturn(true)
        def filterer = new ListFilterer(filter)

        when:
        def filtered = filterer.filter(list)

        then:
        filtered == list
    }
}
