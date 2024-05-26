import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class SILab2Test {
    private List<Item> createList(Item... elems)
    {
        return new ArrayList<>(Arrays.asList(elems));
    }
    @Test
    void everyBranchTest(){
         RuntimeException ex;
         ex=assertThrows(RuntimeException.class,()->SILab2.checkCart(null,5));
         assertTrue(ex.getMessage().contains("allItems list can't be null!"));
         //dokolku se vnese prazna lista
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("",null,9,0));
        ex =  assertThrows(RuntimeException.class,()->SILab2.checkCart(items1,1));
        assertTrue(ex.getMessage().contains("No barcode!"));
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("Elena","2elena",4,9));
        ex =  assertThrows(RuntimeException.class,()->SILab2.checkCart(items2,301));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        List<Item> items = new ArrayList<>();
        items.add(new Item("dva", "784512", 410, 0.1f));
        assertTrue(SILab2.checkCart(items, 50));  // Expected result: true

        items.add(new Item("dva", "784512", 410, 0.1f));
        assertFalse(SILab2.checkCart(items, 40));  // Expected result: false
    }
    @Test
    void MultipleConditionTest()
    {
        //T&&T&&T
        List<Item> items = new ArrayList<>();
        items.add(new Item("eden", "0123456", 500, 5f));
        assertFalse(SILab2.checkCart(items, 40));
        //T&&T&&F
        items.add(new Item("dva", "784512", 410, 0.1f));
        assertFalse(SILab2.checkCart(items, 40));
        //T&&F&&X

        items.add(new Item("dva", "784512", 301, 0));
        assertFalse(SILab2.checkCart(items, 40));

        //F&&X&&X
        items.add(new Item("dva", "784512", 200, 0.0f));
        assertFalse(SILab2.checkCart(items, 40));

    }

}