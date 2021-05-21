import org.junit.*;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class tritypTest {
    trityp tri=new trityp();

    //    Triang = 1 if triangle is scalene
    //    Triang = 2 if triangle is isosceles
    //    Triang = 3 if triangle is equilaterala
    //    Triang = 4 if not a triangle

    @Test
    public void testTriang_4(){
        assertEquals(1,tri.Triang(6,7,8));
        assertEquals(2,tri.Triang(7,7,13));
        assertEquals(2,tri.Triang(7,13,7));
        assertEquals(2,tri.Triang(13,7,7));
        assertEquals(3,tri.Triang(7,7,7));
        assertEquals(4,tri.Triang(6,7,13));
        assertEquals(4,tri.Triang(6,13,7));
        assertEquals(4,tri.Triang(13,7,6));
        assertEquals(4,tri.Triang(6,6,13));
        assertEquals(4,tri.Triang(6,13,6));
        assertEquals(4,tri.Triang(13,6,6));
        assertEquals(4,tri.Triang(-6,7,13));
        assertEquals(4,tri.Triang(6,-7,13));
        assertEquals(4,tri.Triang(6,7,-13));

    }
}