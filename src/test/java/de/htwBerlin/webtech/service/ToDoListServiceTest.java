package de.htwBerlin.webtech.service;

import de.htwBerlin.webtech.persistence.ToDoListRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ToDoListServiceTest implements WithAssertions {

    @Mock
    private ToDoListRepository toDoListRepository;

    @InjectMocks
    private ToDoListService toDoListService;


    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        // given
        Long givenId = 111L;
        doReturn(true).when(toDoListRepository).existsById(givenId);

        // when
        boolean result = toDoListService.deleteById(givenId);

        // then
        verify(toDoListRepository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if person to delete does not exist")
    void should_return_false_if_todo_to_delete_does_not_exist() {
        // given
        Long givenId = 111L;
        doReturn(false).when(toDoListRepository).existsById(givenId);

        // when
        boolean result = toDoListService.deleteById(givenId);

        // then
        verifyNoMoreInteractions(toDoListRepository);
        assertThat(result).isFalse();
    }

}
