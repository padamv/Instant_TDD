package uk.co.ashleyfrieze;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoExamplesTest {
    @Mock
    private SomeInterface someInterface;

    @Test
    public void exampleTest() {
    	when(someInterface.getMatchingSize(anyInt(), anyInt())).thenReturn(1);
    	
    	for(int i = 0; i < 5; i ++) {
    		System.out.println(someInterface.getMatchingSize(1, 2));
    	}
    }

}