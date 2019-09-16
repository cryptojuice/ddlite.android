package com.example.doordashlite.discover

import android.content.SharedPreferences
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.doordashlite.domain.RestaurantInteractor
import com.example.doordashlite.domain.entity.Restaurant
import com.greghaskins.spectrum.Spectrum
import com.greghaskins.spectrum.Spectrum.*
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@RunWith(Spectrum::class)
class DiscoverViewModelSpec {
    @Mock
    lateinit var mockRestaurantInteractor: RestaurantInteractor

    @Mock
    lateinit var mockSharedPreferences: SharedPreferences

    @Mock
    lateinit var mockSharedPreferencesEditor: SharedPreferences.Editor

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val testScheduler = TestScheduler()

    init {
        describe("DiscoverViewModel") {
            beforeEach {
                MockitoAnnotations.initMocks(this)
            }

            describe("init") {
                it("should fetch list of restaurants") {
                    `when`(
                        mockRestaurantInteractor.getRestaurants(
                            anyString(),
                            anyString(),
                            anyInt(),
                            anyInt()
                        )
                    ).thenReturn(
                        Observable.just(listOf())
                    )

                    DiscoverViewModel(testScheduler, mockRestaurantInteractor, mockSharedPreferences)
                    testScheduler.triggerActions()

                    verify(mockRestaurantInteractor, times(1)).getRestaurants(
                        "37.422740",
                        "-122.139956",
                        0,
                        100
                    )
                }

                describe("when fetch is successful") {
                    it("post list of restaurants to live data event") {
                        `when`(
                            mockRestaurantInteractor.getRestaurants(
                                anyString(),
                                anyString(),
                                anyInt(),
                                anyInt()
                            )
                        ).thenReturn(
                            Observable.just(listOf(Restaurant("0","Something Fancy", "Thai", "open", 0.00)))
                        )
                        val viewModel = DiscoverViewModel(testScheduler, mockRestaurantInteractor, mockSharedPreferences)

                        testScheduler.triggerActions()
                        val actual = viewModel.restaurantMutableLiveData.value

                        assertEquals(1, actual?.size)
                        assertEquals("Something Fancy", actual?.get(0)?.name)
                    }
                }
            }

            describe("#onFavoriteClicked") {
                beforeEach {
                    `when`(
                        mockRestaurantInteractor.getRestaurants(
                            anyString(),
                            anyString(),
                            anyInt(),
                            anyInt()
                        )
                    ).thenReturn(
                        Observable.just(listOf(Restaurant("0","Something Fancy", "Thai", "open", 0.00)))
                    )
                }

                describe("when restaurant does not exist in share preferences") {
                    it("sets the restaurant as a favorite") {
//                        `when`(mockSharedPreferences.getBoolean("fav-0", false)).thenReturn(false)
//                        `when`(mockSharedPreferencesEditor.putBoolean("fav-0", true)).thenReturn(mockSharedPreferencesEditor)
//                        val viewModel = DiscoverViewModel(testScheduler, mockRestaurantInteractor, mockSharedPreferences)
//
//                        viewModel.onFavClicked("0")
//
//                        verify(mockSharedPreferencesEditor).putBoolean("fav-0", true)
//
                    }
                }
            }
        }
    }
}