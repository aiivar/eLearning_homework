package ru.kpfu.itis.j903.cw.minsafin.inf_21.n2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.kpfu.itis.j903.cw.minsafin.inf_5.mynavigableset.MyNavigableSet;

import java.util.Comparator;

public class MyNavigableSetTest {
    MyNavigableSet<String> testSet;
    String string1;
    String string2;
    String string3;
    String string4;

    @Before
    public void setUp(){
        string1 = "";
        string2 = "asda";
        string3 = null;
        string4 = "asda";
        testSet = new MyNavigableSet<String>(Comparator.naturalOrder());
    }

    @Test
    public void addTest(){
        testSet.add(string1);
        Assert.assertEquals(1, testSet.size());
    }

    @Test public void addNotUniqueTest(){
        testSet.add(string1);
        testSet.add(string2);
        testSet.add(string4);
        Assert.assertEquals(2, testSet.size());
    }

    @Test
    public void addNullTest(){
        Assert.assertFalse(testSet.add(string3));
    }

    @Test
    public void higherTest(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.higher(string1), string2);
    }

    @Test
    public void lowerTest(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.lower(string2), string1);
    }

    @Test
    public void pollFirstTest(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.pollFirst().equals(string1),testSet.size() == 1);
    }

    @Test
    public void pollLastTest(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.pollLast().equals(string2),testSet.size() == 1);
    }

    @Test
    public void descendingComparatorTest(){
        Assert.assertEquals(testSet.comparator().reversed(), testSet.descendingSet().comparator());
    }

    @Test
    public void iteratorExistsTest(){
        Assert.assertNotNull(testSet.iterator());
    }

    @Test
    public void floorTest(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.floor(string2), string2);
    }

    @Test
    public void floorTest2(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.floor("dsadasd"), string2);
    }

    @Test
    public void ceilingTest(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.ceiling(string1), string1);
    }

    @Test
    public void ceilingTest2(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.ceiling("a"), string2);
    }

    @Test
    public void tailSetTest(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.tailSet(string2).size(), 1);
    }

    @Test
    public void headSetTest(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.headSet(string2).size(), 1);
    }

    @Test
    public void lastTest(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.last(), string2);
    }

    @Test
    public void firstTest(){
        testSet.add(string1);
        testSet.add(string2);
        Assert.assertEquals(testSet.first(), string1);
    }

   @Test
    public void subSetTest(){
        testSet.add(string1);
        testSet.add(string2);
        testSet.add(string3);
        Assert.assertEquals(testSet.subSet(string1, true, string2, false).size(), 1);
   }

   @Test
    public void emptySubSetTest(){
       testSet.add(string1);
       testSet.add(string2);
       testSet.add(string3);
       Assert.assertEquals(testSet.subSet(string1, false, string2, false).size(), 0);
   }

   @Test
    public void hashCodeEqualsTest(){
        testSet.add(string1);
        testSet.add(string2);
       MyNavigableSet<String> test2  = new MyNavigableSet<>(testSet);
       Assert.assertEquals(testSet.hashCode(), test2.hashCode());
   }

   @Test
    public void EqualsTest(){
       testSet.add(string1);
       testSet.add(string2);
       MyNavigableSet<String> test2  = new MyNavigableSet<>(testSet);
       Assert.assertEquals(testSet, test2);
   }

    @Test
    public void hashCodeNotEqualsTest(){
        testSet.add(string1);
        testSet.add(string2);
        MyNavigableSet<String> test2  = new MyNavigableSet<>(testSet);
        test2.add("dsad");
        Assert.assertNotEquals(testSet.hashCode(), test2.hashCode());
    }

    @Test
    public void NotEqualsTest(){
        testSet.add(string1);
        testSet.add(string2);
        MyNavigableSet<String> test2  = new MyNavigableSet<>(testSet);
        test2.add("sd");
        Assert.assertNotEquals(testSet, test2);
    }
}
