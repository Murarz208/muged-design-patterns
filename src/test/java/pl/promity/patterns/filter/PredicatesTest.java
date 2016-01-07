package pl.promity.patterns.filter;

import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import pl.promity.patterns.common.UserData;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PredicatesTest {

    private List<UserData> dataToFilter;

    private UserData steveJobs;
    private UserData stevenSpielberg;

    @Before
    public void setUp() throws Exception {
        steveJobs = new UserData(55, "steve.jobs", "Steve Jobs", "342 Hillside Avenue Mechanicsville, VA 23111");
        stevenSpielberg = new UserData(70, "steven.spielberg", "Steven Spielberg", "121 Hillside Avenue Mechanicsville, VA 78549");
        createDataToFilter();
    }

    private void createDataToFilter() {
        dataToFilter = Lists.newArrayList(
            new UserData(50, "mike.tyson", "Mike Tyson", "704 Somerset Drive Green Bay, WI 54302"),
            new UserData(60, "michael.jackson", "Michael Jackson", "941 Sherwood Drive Deland, FL 32720"),
            steveJobs, stevenSpielberg,
            new UserData(95, "walt.disney", "Walter Disney", "Fridge")
        );
    }

    @Test
    public void testJava8Predicate() throws Exception {
        //given
        java.util.function.Predicate<UserData> javaPredicate = new StartsWithJava8Predicate("steve");

        //when
        List<UserData> filteredList = dataToFilter.stream()
                .filter(javaPredicate)
                .collect(Collectors.<UserData>toList());

        //then
        assertThat(filteredList).isNotEmpty().hasSize(2).containsExactly(steveJobs, stevenSpielberg);
        printListWithLineBreaks(filteredList);
    }

    private void printListWithLineBreaks(List<UserData> listToPrint){
        System.out.println(
            listToPrint.stream().map( userData -> userData.toString() )
                .collect( Collectors.joining(System.getProperty("line.separator")))
        );
    }

    @Test
    public void testGuavaPredicate() throws Exception {
        //given
        com.google.common.base.Predicate<UserData> guavaPredicate = new StartsWithGuavaPredicate("steve");

        //when
        List<UserData> filteredList = FluentIterable.from(dataToFilter).filter(guavaPredicate).toList();

        //then
        assertThat(filteredList).isNotEmpty().hasSize(2).containsExactly(steveJobs, stevenSpielberg);
        printListWithLineBreaks(filteredList);
    }

    @Test
    public void testPredicateOrConditionalJava8() throws Exception {
        //given
        java.util.function.Predicate<UserData> startsWithPredicate = new StartsWithJava8Predicate("steve");
        java.util.function.Predicate<UserData> agePredicate = new IsOlderThanJava8Predicate(60);

        //when
        List<UserData> filteredList = dataToFilter.stream()
                .filter(agePredicate.and(startsWithPredicate))
                .collect(Collectors.<UserData>toList());

        //then
        assertThat(filteredList).isNotEmpty().hasSize(1).containsExactly(stevenSpielberg);
        printListWithLineBreaks(filteredList);
    }

    @Test
    public void testPredicateOrConditionalGuava() throws Exception {
        //given
        com.google.common.base.Predicate<UserData> startsWithPredicate = new StartsWithGuavaPredicate("steve");
        com.google.common.base.Predicate<UserData> agePredicate = new IsOlderThanGuavaPredicate(60);

        //when
        List<UserData> filteredList = FluentIterable.from(dataToFilter).filter(
                Predicates.and(startsWithPredicate, agePredicate)
        ).toList();

        //then
        assertThat(filteredList).isNotEmpty().hasSize(1).containsExactly(stevenSpielberg);
        printListWithLineBreaks(filteredList);
    }
}