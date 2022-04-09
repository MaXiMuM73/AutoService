//package com.simbirsoft.cars;
//
//import org.junit.Test;
//import ru.citilab.entity.Request;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestCollection {
//
//    @Test
//    public void testCol() {
//        List<Request> list = new ArrayList<>();
//        Request request = Request.builder().build();
//        list.add(request);
//        request.setRequestFull("test");
//        request.setMachine("test");
//        System.out.println(list);
//
//    }
//
//    @Test
//    public void testGetCollectionElement() {
//        List<Boolean> list = new ArrayList<>();
//        list.add(true);
//        list.add(false);
//        list.add(true);
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        boolean falSe = Boolean.parseBoolean("FalSe");
//        System.out.println(falSe);
//        boolean b = "test" instanceof String;
//    }
//
//    @Test
//    public void testNPE() {
//        Request request = Request.builder()
//                .date(LocalDateTime.now())
//                .build();
//        System.out.println(request);
//        System.out.println(request.getMachine() + ": machine");
//    }
//}
