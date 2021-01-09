package com.example.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.moviecatalogue.R
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyShows = DataDummy.generateDummyTVShows()
    private val dummyGenres = DataDummy.generateDummyGenres(dummyMovies[0].filmId)

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.text_title_value)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title_value)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.text_date_value)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date_value)).check(matches(withText(dummyMovies[0].releaseDate)))
        onView(withId(R.id.text_rating_value)).check(matches(isDisplayed()))
        onView(withId(R.id.text_rating_value)).check(matches(withText(dummyMovies[0].rating.toString())))
        onView(withId(R.id.text_language_value)).check(matches(isDisplayed()))
        onView(withId(R.id.text_language_value)).check(matches(withText(dummyMovies[0].language)))
        onView(withId(R.id.text_description_value)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description_value)).check(matches(withText(dummyMovies[0].description)))
        onView(withId(R.id.rv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyGenres.size
            )
        )
    }

    @Test
    fun loadShows() {
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyShows.size
            )
        )
    }

    @Test
    fun loadDetailShows() {
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.text_title_value)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title_value)).check(matches(withText(dummyShows[0].title)))
        onView(withId(R.id.text_date_value)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date_value)).check(matches(withText(dummyShows[0].releaseDate)))
        onView(withId(R.id.text_rating_value)).check(matches(isDisplayed()))
        onView(withId(R.id.text_rating_value)).check(matches(withText(dummyShows[0].rating.toString())))
        onView(withId(R.id.text_language_value)).check(matches(isDisplayed()))
        onView(withId(R.id.text_language_value)).check(matches(withText(dummyShows[0].language)))
        onView(withId(R.id.text_description_value)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description_value)).check(matches(withText(dummyShows[0].description)))
    }
}