package io.imrekaszab.algorithms;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.bloco.faker.Faker;
import io.imrekaszab.algorithms.data.model.AlgorithmPerformance;
import io.imrekaszab.algorithms.data.model.sort.BubbleSort;
import io.imrekaszab.algorithms.data.service.MockAlgorithmFactory;

import static com.google.common.truth.Truth.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AlgorithmsUnitTest {

    private MockAlgorithmFactory algorithmFactory;

    @Mock
    private Faker faker;

    @Before
    public void init() {
        algorithmFactory = new MockAlgorithmFactory(faker);
    }

    @Test
    public void bubbleSort_isQuadratic() {
        int[] intArray = new int[]{2, 0, 1};
        BubbleSort bubbleSort = new BubbleSort(intArray);

        AlgorithmPerformance result = bubbleSort.getPerformance();

        assertThat(result).isEqualTo(AlgorithmPerformance.QUADRATIC);
    }
}