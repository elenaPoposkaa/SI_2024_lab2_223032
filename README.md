
Елена Попоска 223032

![image](https://github.com/elenaPoposkaa/SI_2024_lab2_223032/assets/139128813/89134fe6-f724-4ce5-a5da-7cce7ed46c49)

ЦИКЛОМАТСКА КОМПЛЕКСНОСТ
Цикломатската комплекснот на овој код е 10,истата ја добив преку формулата  P+1,каде бројот на P е број на предикатни јазли.Во случајов P=9, па цикломатската комплексност е 10.
Јазли кој се разгрануваат се 9 и плус еден = 10

Тест случаи според критериумот Every Branch
1.Со првиот тест ги поминувам бранчовите од 1,2-3 и од 3-27 целта е да внесам празна листа без аргументи и било која сума на payment и со тоа ке можам да го поминам бранчот од 3-27.

              RuntimeException ex;
         ex=assertThrows(RuntimeException.class,()->SILab2.checkCart(null,5));
         assertTrue(ex.getMessage().contains("allItems list can't be null!"));
2. Во вториот тест случаи сакам да фрли exception("No barcode!"), со ова ќе го поминам бранчот од 9-20.Со овој тест случај поминувам 1,2-4 , 4-5.1 влегувам во for loop гледам дека листата не ми е празна  5.2-6 , 6-7 целта е и името да биде празно и влегувам во 7-8, 8-9 кодот гледа дека barcode ми е поставен на null и следи 9-20 20-27 излегува од функицијата со exception.

              List<Item> items1 = new ArrayList<>();
        items1.add(new Item("",null,9,0));
        ex =  assertThrows(RuntimeException.class,()->SILab2.checkCart(items1,1));
        assertTrue(ex.getMessage().contains("No barcode!"));
   
4. Целта ми е да фрлам exception ("Invalid character") и да ги поминам тие бранчови. Во barcode да имам invalid character односно да имам различен карактер од 0123456789 во barcode. 1,2-4 , 4-5.1,5.2 ,5.2-6 , 6-7 името не ми е празно не влегувам во 8, 9-10 , 10-11, 11-12.1 влегувам во for loop 12.1-12.2 barcode не е празен стринг 12.2-13, 13-14 проверува дали карактерот е во allowed стрингот значи не е и 14-15 фрлам exception. 15-27.
   
             List<Item> items2 = new ArrayList<>();
        items2.add(new Item("Elena","2elena",4,9));
        ex =  assertThrows(RuntimeException.class,()->SILab2.checkCart(items2,301));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));
   
4. Тест примерот ги поминува бранчовите 1 -> 2 -> 4 -> 5.1 -> 6 -> 7 -> 9 -> 10 -> 11 -> 12.1 -> 13 -> 14 -> 16 -> 17 -> 18 -> 21 -> 23 -> 24 -> 25 враќа True како резултат влегува во 25
   
               List<Item> items = new ArrayList<>();
        items.add(new Item("dva", "784512", 410, 0.1f));
        assertTrue(SILab2.checkCart(items, 50));  // Expected result: true
   
5. Тест примерот поминува во бранчовите 1 -> 2 -> 4 -> 5.1 -> 6 -> 7 -> 9 -> 10 -> 11 -> 12.1 -> 13 -> 14 -> 16 -> 17 -> 18 -> 21 -> 23 -> 24 -> 26 влегува од 24-26 враќа резултат False
   
              items.add(new Item("dva", "784512", 410, 0.1f));
        assertFalse(SILab2.checkCart(items, 40));  // Expected result: false
   

Тест случаи според критериумот Multiple Condition
    ![MultipleConditions](https://github.com/elenaPoposkaa/SI_2024_lab2_223032/assets/139128813/213a5c99-7343-4a5d-a493-68499f98651f)

        
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

