package io.imrekaszab.algorithms;

import androidx.test.espresso.PerformException;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.imrekaszab.algorithms.ui.MainActivity;
import io.imrekaszab.algorithms.ui.adapter.AlgorithmsAdapter;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class AlgorithmsRecyclerViewTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
        new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test(expected = PerformException.class)
    public void itemWithText_doesNotExist() {
        onView(ViewMatchers.withId(R.id.mainRecyclerView))
            .perform(RecyclerViewActions.scrollTo(
                hasDescendant(withText("not in the list"))
            ));
    }

    @Test
    public void firstItem_hasSectionText() {
        onView(ViewMatchers.withId(R.id.mainRecyclerView))
            .perform(RecyclerViewActions.scrollToHolder(isTheFirst()));

        String firstElementText =
            getApplicationContext().getResources().getString(R.string.algorithm_list_section_item_sort);
        onView(withText(firstElementText)).check(matches(isDisplayed()));
    }

    @Test
    public void firstItem_iSection() {
        onView(ViewMatchers.withId(R.id.mainRecyclerView))
            .perform(RecyclerViewActions.scrollToHolder(isTheFirst()));

        onView(withId(R.id.sectionItemTitle)).check(matches(isDisplayed()));
    }

    private static Matcher<AlgorithmsAdapter.ViewHolder> isTheFirst() {
        return new TypeSafeMatcher<AlgorithmsAdapter.ViewHolder>() {
            @Override
            protected boolean matchesSafely(AlgorithmsAdapter.ViewHolder customHolder) {
                return customHolder.getLayoutPosition() == 0;
            }

            @Override
            public void describeTo(Description description) {
                // no-op
            }
        };
    }
}
