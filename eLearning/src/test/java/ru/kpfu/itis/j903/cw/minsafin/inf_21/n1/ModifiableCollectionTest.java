package ru.kpfu.itis.j903.cw.minsafin.inf_21.n1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.kpfu.itis.j903.cw.minsafin.inf_4.ModifiableCollection;

import java.util.HashSet;
import java.util.Set;

public class ModifiableCollectionTest {
    ModifiableCollection<Object> objects;
    private Object obj1;
    private Object obj2;
    private Object obj3;
    private Object obj4;

    @Before

    public void setUp() {
        objects = new ModifiableCollection<>();
        obj1 = new Object();
        obj2 = new Integer(5);
        obj3 = new String();
        obj4 = null;
    }

    @Test
    public void getSizeTest() {
        Assert.assertEquals(0, objects.size());
    }

    @Test
    public void addSizeTest() {
        int expected = 3;
        objects.add(obj1);
        objects.add(obj2);
        objects.add(obj3);
        Assert.assertEquals(expected, objects.size());
    }

    @Test
    public void addBooleanTest() {
        Assert.assertTrue(objects.add(obj1));
    }

    @Test
    public void removeBooleanTest() {
        objects.add(obj1);
        Assert.assertTrue(objects.remove(obj1));
    }

    @Test
    public void removeNonExistingObject() {
        objects.add(obj1);
        Assert.assertFalse(objects.remove(obj2));
    }

    @Test
    public void iteratorExistsTest() {
        Assert.assertNotNull(objects.iterator());
    }

    @Test
    public void sizeAfterRemoveTest() {
        objects.add(obj1);
        int size1 = objects.size();
        objects.remove(obj1);
        int size2 = objects.size();
        int difference = size1 - size2;
        int expected = 1;
        Assert.assertEquals(expected, difference);
    }

    @Test
    public void collectionConstructorTest() {
        Set<Object> set = new HashSet<>();
        set.add(obj1);
        set.add(obj2);
        set.add(obj3);
        ModifiableCollection<Object> modifiableCollection = new ModifiableCollection<>(set);
        Assert.assertEquals(modifiableCollection.size(), set.size());
    }

    @Test
    public void removeNullTest() {
        objects.add(obj4);
        Assert.assertTrue(objects.remove(obj4));
    }

    @Test
    public void arrayTest() {
        Object[] objects1 = new Object[3];
        objects1[0] = obj1;
        objects1[1] = obj2;
        objects1[2] = obj3;
        objects.add(obj1);
        objects.add(obj2);
        objects.add(obj3);
        Assert.assertArrayEquals(objects1, objects.toArray());
    }

    @Test
    public void hashCodeNotEqualsTest() {
        objects.add(obj1);
        objects.add(obj2);
        objects.add(obj3);
        ModifiableCollection<Object> collection = new ModifiableCollection<>();
        collection.add(obj2);
        collection.add(obj3);
        collection.add(obj4);
        Assert.assertNotEquals(objects.hashCode(), collection.hashCode());
    }

    @Test
    public void hashCodeEqualsTest() {
        objects.add(obj1);
        objects.add(obj2);
        objects.add(obj3);
        ModifiableCollection<Object> objects2 = new ModifiableCollection<>(objects);
        Assert.assertEquals(objects.hashCode(), objects2.hashCode());
    }

    @Test
    public void notEqualsTest(){
        objects.add(obj1);
        objects.add(obj2);
        objects.add(obj3);
        ModifiableCollection<Object> collection = new ModifiableCollection<>();
        collection.add(obj2);
        collection.add(obj3);
        collection.add(obj4);
        Assert.assertFalse(objects.equals(collection));
    }

    @Test
    public void equalsTest(){
        objects.add(obj1);
        objects.add(obj2);
        objects.add(obj3);
        ModifiableCollection<Object> objects2 = new ModifiableCollection<>(objects);
        Assert.assertTrue(objects.equals(objects2));
    }
}
