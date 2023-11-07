import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ColloqTest {

    @Test
    public void testGetFactorials() {
        List<Long> expected = Arrays.asList(1L, 1L, 2L, 6L, 24L, 120L);
        List<Long> actual = Colloquium.getFactorials(5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetFactorialsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colloquium.getFactorials(-1);
        });
    }

    @Test
    public void testRemoveDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = Colloquium.removeDuplicates(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveDuplicatesNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Colloquium.removeDuplicates(null);
        });
    }

    @Test
    public void testReverseLinkedList() {
        Colloquium.Node<Integer> head = new Colloquium.Node<>(1);
        head.next = new Colloquium.Node<>(2);
        head.next.next = new Colloquium.Node<>(3);

        Colloquium.Node<Integer> expected = new Colloquium.Node<>(3);
        expected.next = new Colloquium.Node<>(2);
        expected.next.next = new Colloquium.Node<>(1);

        Colloquium.Node<Integer> actual = Colloquium.reverseLinkedList(head);
        assertLinkedListEquals(expected, actual);
    }

    private <T> void assertLinkedListEquals(Colloquium.Node<T> expected, Colloquium.Node<T> actual) {
        while (expected != null && actual != null) {
            assertEquals(expected.data, actual.data);
            expected = expected.next;
            actual = actual.next;
        }
        Assertions.assertNull(expected);
        Assertions.assertNull(actual);
    }
}