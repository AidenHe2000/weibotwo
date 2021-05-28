import org.junit.*;

import static org.junit.Assert.assertEquals;

public class tritypTest {
    trityp tri = new trityp();
    //    Triang = 1 if triangle is scalene
    //    Triang = 2 if triangle is isosceles
    //    Triang = 3 if triangle is equilaterala
    //    Triang = 4 if not a triangle


    @Test
    public void testTriang_1() {
        assertEquals(1, tri.Triang(5, 3, 4));
    }

    @Test
    public void testTriang_2() {
        assertEquals(2, tri.Triang(2, 2, 3));
        assertEquals(2, tri.Triang(2, 3, 2));
        assertEquals(2, tri.Triang(3, 2, 2));
    }

    @Test
    public void testTriang_3() {
        assertEquals(3, tri.Triang(1, 1, 1));
    }


    @Test
    public void testTriang_4() {
        assertEquals(4, tri.Triang(-1, 1, 1));
        assertEquals(4, tri.Triang(1, -1, 1));
        assertEquals(4, tri.Triang(1, 1, -1));
        assertEquals(4, tri.Triang(1, 2, 3));
        assertEquals(4, tri.Triang(2, 3, 1));
        assertEquals(4, tri.Triang(3, 1, 2));
        assertEquals(4, tri.Triang(3, 1, 2));
        assertEquals(4, tri.Triang(1, 1, 2));
        assertEquals(4, tri.Triang(1, 2, 1));
        assertEquals(4, tri.Triang(2, 1, 1));
    }
}
