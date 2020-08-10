package com.alankurniadi.submission2jatpackpromovie.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.alankurniadi.submission2jatpackpromovie.R
import com.alankurniadi.submission2jatpackpromovie.utils.DataDummy
import com.alankurniadi.submission2jatpackpromovie.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyTrending = DataDummy.getTrending()
    private val dummyMovie = DataDummy.getNowPlayingMovie()
    private val dummyTvShow = DataDummy.getAiringTvShow()
    private val dummyDetailTv = DataDummy.getTvShowDetail()
    private val dummyDetailMovie = DataDummy.getMovieDetail()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setUp(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadAllList(){
        //onView(withId(R.id.rv_this_week)).perform(swipeLeft())
        //onView(withId(R.id.rv_this_week)).perform(swipeRight())
        onView(withId(R.id.rv_this_week)).check(matches(isDisplayed()))

        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))

        onView(withId(R.id.rv_tv)).perform(ScrollToAction())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))

    }

    @Test
    fun loadDetailTrending() {
        onView(withId(R.id.rv_this_week)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_this_week)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_backdroup_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.img_ic_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.img_start)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote_tv)).check(matches(withText(dummyDetailTv[0].vote_average.toString())))
        onView(withId(R.id.img_date_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_tv)).check(matches(withText(dummyDetailTv[0].first_air_date)))
        onView(withId(R.id.tv_title_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_tv)).check(matches(withText(dummyDetailTv[0].name)))
        onView(withId(R.id.tv_detail_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tv)).check(matches(withText(dummyDetailTv[0].overview)))
        onView(withId(R.id.detail_activity_tv)).perform(swipeUp())
        onView(withId(R.id.detail_activity_tv)).perform(swipeDown())
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_backdroup_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_movie)).check(matches(withText(dummyDetailMovie.title)))
        onView(withId(R.id.img_ic_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.img_start)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote)).check(matches(withText(dummyDetailMovie.vote_average.toString())))
        onView(withId(R.id.img_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(withText(dummyDetailMovie.release_date)))
        onView(withId(R.id.tv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail)).check(matches(withText(dummyDetailMovie.overview)))
        onView(withId(R.id.detail_activity_movie)).perform(swipeUp())
        onView(withId(R.id.detail_activity_movie)).perform(swipeDown())
    }

    @Test
    fun loadTvShowList(){
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }
}